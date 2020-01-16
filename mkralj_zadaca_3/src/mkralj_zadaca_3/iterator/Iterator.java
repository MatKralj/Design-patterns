package mkralj_zadaca_3.iterator;

public interface Iterator <T>{
    
    public boolean hasNext();
    public T next();
    public void remove();
    
    public void setPosition(int p);
    public int getPosition();
}
