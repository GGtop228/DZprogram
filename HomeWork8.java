public class MyLinkedLIst<E> {
    private class Node{
        public E element;
        public Node next;
        public Node prev;

        public Node(Node next, E element, Node prev){
            this.element=element;
            this.next=next;
            this.prev=prev;
        }
    }
    private int size;
    private Node first;
    private Node last;

    public MyLinkedLIst(){
        first=null;
        last=null;
        size=0;
    }
    private Node getNode(int index){
        if (index<0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
        Node curNode = first;
        for (int i=0;i<index;i++){
            curNode = curNode.next;
        }
        return curNode;

    }
    public E get(int index){
        Node curNode = getNode(index);
        return curNode.element;
    }
    public  int indexOf(Object obj){
        Node curNode = first;
        for (int i=0;i<size;i++){
            if (curNode.element.equals(obj)){
                return i;
            }
            curNode=curNode.next;
        }
        return -1;
    }
    public boolean add (E element){
        if (first == null){
            Node newNode = new Node(null, element, null);
            first=newNode;
            last=newNode;
        }else {
            Node newNode=new Node(null, element,last);
            last.next=newNode;
            last = newNode;
        }
        size++;
        return true;
    }
    public void add(int index, E element){
        if (index == size){
            add(element);
        }else if(index==0){
            Node newNode=new Node(first,element,null);
            first.prev=newNode;
            first = newNode;
            size++;
        }else{

            Node curNode = getNode(index);
            Node newNode = new Node(curNode,element,curNode.prev);
            curNode.prev.next=newNode;
            curNode.prev=newNode;
            size++;
        }
    }
    public E remove(int index){
        Node oldNode = getNode(index);
        if (size==1){
            first=null;
            last=null;
        }else if(oldNode==first){
            first.next.prev=null;
            first=first.next;
        }else if(oldNode==last){
            last.prev.next=null;
            last=last.prev;
        }else {
            oldNode.prev.next=oldNode.next;
            oldNode.next.prev=oldNode.prev;
        }
        size--;
        return oldNode.element;
    }
    public boolean remove(Object obj){
        int index=indexOf(obj);
        if(index!=-1){
            remove(index);
            return true;
        }else {
            return false;
        }
    }
    public String toString(){
        if(first==null){
            return "list ...";
        }
        String str ="[";
        Node curNode = first;
        for (int i = 0; i < size-1; i++) {
            str=str+curNode.element.toString()+", ";
            curNode=curNode.next;
        }
        str=str+curNode.element.toString()+"]";
        return str;
    }
}
