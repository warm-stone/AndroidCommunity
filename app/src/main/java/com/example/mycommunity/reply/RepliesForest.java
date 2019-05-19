package com.example.mycommunity.reply;

import java.util.ArrayList;
import java.util.List;

public class RepliesForest {
    private List<Reply> replies;
    private List<Node> nodes = new ArrayList<>();


    public RepliesForest(List<Reply> replies) {
        this.replies = replies;
        initNode();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    class Node {
        Reply previous;
        Reply current;

        private Node(Reply current) {
            this.current = current;
        }
    }

    private Node getNode(Reply current) {
        Node node = new Node(current);
        if (current.getParentId() != 0) {
            int i = 0;
            Reply reply;
            do {
                reply = replies.get(i++);
            } while (current.getParentId() != reply.getId());
            node.previous = reply;
        }
        return node;
    }

    private void initNode() {
        for (Reply reply : replies)
            nodes.add(getNode(reply));
    }

}
