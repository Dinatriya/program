

import java.util.*;
import java.util.concurrent.Semaphore;


class Paper
{
    private Semaphore sem;
    private String article;
    private String namePaper;
    private String description;
    private int price;

    public String getArticle() { return article; }
    public String getNamePaper() { return  namePaper; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }

    Paper()
    {
        this.article = null;
        this.namePaper = null;
        this.description = null;
    }
    Paper(String article, String namePaper, String description, int price)
    {
        this.article = article;
        this.namePaper = namePaper;
        this.description = description;
        this.price = price;
    }
    @Override
    public String toString()
    {
        return article + " | " + namePaper + " | " + description + " | " + price + "\n";
    }
}

// класс газетного киоска
class NewsStand<T> extends Thread
{
    private Semaphore sem;
    private ArrayList<T> listPapers; // "склад" газет
    private boolean isOpen;

    public boolean getIsOpen() { return isOpen; }
    public Semaphore getSem() { return sem; }
    public ArrayList<T> getListPaper() { return listPapers; }

    NewsStand()
    {
        listPapers = new ArrayList<T>();
        isOpen = true;
    }
    public void addPaper(T item)
    {
        listPapers.add(item);
    }
    public void getInfo()
    {

    }
    @Override
    public void run()
    {
        sem = new Semaphore(1, true);
        while (isOpen) {
            if (listPapers.size() == 0) isOpen = false;
            this.interrupt();
        }
    }
}

// класс покупателя
class Customer<T> extends Thread
{
    private int idCustomer;
    private boolean onDeque;
    private NewsStand NS;
    private Semaphore sem;
    private T data;

    public int getIdCustomer() { return idCustomer; }

    Customer(int idCustomer, NewsStand NS, T data)
    {
        this.idCustomer = idCustomer;
        this.NS = NS;
        this.sem = NS.getSem();
        this.data = data;
        onDeque = false;
    }

    @Override
    public void run()
    {
        try {
            checkDeque();
            sem.acquire(1);
            putPaper();
            sem.release();
        } catch (InterruptedException e) {

        }
    }

    void putPaper()
    {
        if (!NS.getIsOpen()) return;
        int rnd = new Random().nextInt(2000);
        try {
            sleep(rnd);
            if (NS.getListPaper().contains(data)) {
                System.out.println("Id: " + idCustomer + " взял газету: " + data);
                NS.getListPaper().remove(data);
            } else {
                System.out.println("Id: " + idCustomer + " не смог взять газету(" + data + "), ибо её не было");
            }
        } catch (InterruptedException e) {

        }
        onDeque = false;
    }

    public void checkDeque()
    {
        if (onDeque) return;
        System.out.println("Id: " + idCustomer + " встал в очередь");
        onDeque = true;
    }
}

public class testmainclass {
	public static void main(String[] args) {
        final int sizePapers = 10;
        Paper papers[] = {
                new Paper("583021", "Газета новости", "www.paper.ru", 100),
                new Paper("068301", "Аргументы и факты", "www.argumentandfact.ru", 75),
                new Paper("079382", "Комсомольская правда", "www.komsomol.ru", 80),
                new Paper("593534", "Доброе утро", "www.goodmorning.ru", 55),
                new Paper("406002", "Еженедельник", "www.eshen.ru", 45),
                new Paper("503010", "Курс на будущее", "www.nowmoscow.ru", 24),
                new Paper("684890", "Наше Подмосковье", "www.ouroblact.ru", 12),
                new Paper("958391", "Русский народ", "www.russiapeople.ru", 35),
                new Paper("359391", "Люберцы", "www.lubertsy.ru", 30),
                new Paper("503964", "Всё о Европе", "www.europa.ru", 75)
        };
        NewsStand<Paper> NS = new NewsStand<>();
        for (int i = 0; i < 5; i++) {
            int random = 0 + (int) (Math.random() * sizePapers);
            NS.addPaper(papers[random]);
        }
        try {
            NS.start();
            int i = 1;
            while(NS.getIsOpen()) {
                Customer c = new Customer(i, NS, papers[0 + (int)(Math.random() * sizePapers)]);
                c.start();
                i++;
                Thread.sleep(100);
            }
            NS.interrupt();
        } catch (Exception e) {

        }
    }
}
