package ua.training.linkedlist;

import java.util.Iterator;

public class CustomLinkedListImpl<E> implements CustomLinkedList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public CustomLinkedListImpl() {
        lastNode = new Node<E>(firstNode, null, null);
        firstNode = new Node<E>(null, null, lastNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> previous = lastNode;
        previous.setCurrentElement(e);
        lastNode = new Node<E>(previous, null, null);
        previous.setNextNode(lastNode);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> next = firstNode;
        next.setCurrentElement(e);
        firstNode = new Node<E>(null, null, next);
        next.setPreviousNode(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int counter) {
        Node<E> targetNode = firstNode.getNextNode();
        for (int i = 0; i < counter; i++) {
            targetNode = targetNode.getNextNode();
        }
        return targetNode.getCurrentElement();
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator descendingIterator() {
        return new Iterator() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node<E> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<E> getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node<E> lastNode) {
        this.lastNode = lastNode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    private class Node<E> {
        private Node<E> previousNode;
        private E currentElement;
        private Node<E> nextNode;

        public Node(Node<E> previousNode, E currentElement, Node<E> nextNode) {
            this.previousNode = previousNode;
            this.currentElement = currentElement;
            this.nextNode = nextNode;
        }

        public Node<E> getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node<E> previousNode) {
            this.previousNode = previousNode;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
