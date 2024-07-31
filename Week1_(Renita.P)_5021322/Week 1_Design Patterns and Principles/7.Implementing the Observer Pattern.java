import java.util.ArrayList;
import java.util.List;

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private int stockPrice;

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

interface Observer {
    void update(int stockPrice);
}

class MobileApp implements Observer {
    @Override
    public void update(int stockPrice) {
        System.out.println("MobileApp received stock price update: " + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(int stockPrice) {
        System.out.println("WebApp received stock price update: " + stockPrice);
    }
}

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setStockPrice(100);
        stockMarket.setStockPrice(200);
    }
}
