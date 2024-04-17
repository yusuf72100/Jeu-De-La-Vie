public interface Observable {
    public void attachObservateur(Observateur observer);

    public void detachObservateur(Observateur observer);

    public void notifyObservers();
}