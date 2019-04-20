package com.example.mycommunity;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CacheManager<T extends LitePalSupport> {

    private Class<T> clazz;

    public CacheManager() {
        clazz = new RawDao<T>().clazz;
    }

    /*
     * 存储缓存并检查是否已存在
     * Save cache and check the exist
     *
     * @return 缓存中是否已存在
     * */
    public boolean saveData(List<T> cache) {
        for (T t : cache) {
            if (!t.isSaved())
                t.save();
            else
                return false;
        }
        return true;
    }

    /*
     * 获取缓存数据并返回是否已到最后一条
     * Get cache and return true if the data exist.
     * @deviation 偏移量
     * @size 页面规格
     *
     * @return 获取数据是否存在
     *         whether the data exists.
     *
     * */
    public List<T> getData(int deviation, int size) {
        List<T> data = new ArrayList<>();
        try {
            data = LitePal.limit(size)
                    .offset(deviation).find(clazz);
        } catch (NullPointerException e) {
            return data;
        }
        return data;
    }

    public T getLast() {
        return LitePal.findFirst(clazz);
    }

    public T getFirst() {
        return LitePal.findLast(clazz);
    }
}

class RawDao<T> {
    Class<T> clazz;

    @SuppressWarnings("unchecked")
    RawDao() {
        @SuppressWarnings("rawtypes")
        Class clazz = getClass();

        while (clazz != Object.class) {
            Type t = clazz.getGenericSuperclass();
            if (t instanceof ParameterizedType) {
                Type[] args = ((ParameterizedType) t).getActualTypeArguments();
                if (args[0] instanceof Class) {
                    this.clazz = (Class<T>) args[0];
                    break;
                }
            }
            clazz = clazz.getSuperclass();
        }
    }
}
