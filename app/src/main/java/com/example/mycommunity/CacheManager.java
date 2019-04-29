package com.example.mycommunity;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public class CacheManager<T extends LitePalSupport> {

    private Class<T> clazz;

    public CacheManager(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void saveData(final List<T> cache) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<T> marks = getData(0, 8);
                boolean isSaved = false;
                if (marks != null) {
                    for (T t : cache) {
                        for (T mark : marks) {
                            if (mark.equals(t)) {
                                isSaved = true;
                                break;
                            }
                        }
                        if (isSaved) {
                            isSaved = false;
                            continue;
                        } else
                            t.save();
                    }
                } else {
                    for (T t : cache) {
                        t.save();
                    }
                }
            }
        }).start();
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
        List<T> data = null;
        try {
            data = LitePal.limit(size)
                    .offset(deviation).find(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }



    public T getFirst() {
        return LitePal.findLast(clazz);
    }
}

