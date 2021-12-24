class Authors
{
    private int idnumberauthors;
    private String fiopeoplerauthors;
    
    public int Getidnumberauthors() { return idnumberauthors; }
    Authors()
    {
        this.idnumberauthors = 0;
        this.fiopeoplerauthors = "NULL";        
    }
    Authors(int idnumberauthors)
    {
        this.idnumberauthors = idnumberauthors;
        this.fiopeoplerauthors = "NULL";        
    }
    Authors(int idnumberauthors, String fiopeoplerauthors)
    {
        this.idnumberauthors = idnumberauthors;
        this.fiopeoplerauthors = fiopeoplerauthors;       
    }
    @Override
    public String toString()
    {
        return idnumberauthors 
		+ " | " 
		+ fiopeoplerauthors;
    }
}

class Sections extends TreeSet<Sections> implements Comparable<Sections>
{
    private int idsectionsections;
    private String namesectionsections;
    public int Getidsectionsections() { return idsectionsections; }
    Sections()
    {
        this.idsectionsections = 0;
        this.namesectionsections = "NULL";      
    }
    Sections(int idsectionsections)
    {
        this.idsectionsections = idsectionsections;
    }
    Sections(int idsectionsections, String namesectionsections)
    {
        this.idsectionsections = idsectionsections;
        this.namesectionsections = namesectionsections;
    }
    @Override
    public int compareTo(Sections arg1)
    {
        return idsectionsections - arg1.Getidsectionsections();
    }
    @Override
    public String toString()
    {
        return idsectionsections 
		+ " | " 
		+ namesectionsections;
    }
}

class Pictures
{
    private int idpictures;
    private String namepictures;
	private Authors idnumberauthors;
    private Sections idsectionsections;
	private String technic;
	private String sizespictures;
	private int bitcoins;

    Pictures()
    {
        this.idpictures = 0;
		this.namepictures = "NULL";
        this.idnumberauthors = null;
        this.idsectionsections = null;
		this.technic = "NULL";
		this.sizespictures = "NULL";
		this.bitcoins = 0;
    }
    Pictures(int idpictures, String namepictures, Authors idnumberauthors, Sections idsectionsections, String technic, String sizespictures, int bitcoins)
    {
        this.idpictures = idpictures;
		this.namepictures = namepictures;
		this.idnumberauthors = idnumberauthors;
        this.idsectionsections = idsectionsections;
		this.technic = technic;
		this.sizespictures = sizespictures;
		this.bitcoins = bitcoins;
        
    }
    @Override
    public String toString()
    {
        return idpictures 
		+ " | " 
		+ namepictures 
		+ " | " 
		+ idnumberauthors.Getidnumberauthors()
		+ " | " 
		+ idsectionsections.Getidsectionsections() 
		+ " | "
		+ technic
		+ " | "
		+ sizespictures
		+ " | "
		+ bitcoins
		; 
    }
}
 


public class Main {

    public static void main(String[] args) {
        Authors TabAuthors[] = {
                new Authors(100, "Крупень С."),
                new Authors(101, "Беляев Р.Х."),
                new Authors(103, "Кручинкин Ю."),
                new Authors(104, "Малевич П.") 
        };
        Sections TabSections[] = {
                new Sections(10, "Городской пейзаж"),
                new Sections(11, "Натюрморт")
        };
        Pictures TabPictures[] = {
                new Pictures(1001, "Даниловский монастырь",	TabAuthors[1], TabSections[0], "Пастель", "40x50", 40000),
                new Pictures(1002, "Весёлый денёк", 		TabAuthors[1], TabSections[1], "Масло, холст", "45x70", 15000),
                new Pictures(1003, "Старая Москва", 		TabAuthors[2], TabSections[0], "Акварель", "30x60", 12000),
                new Pictures(1004, "Старая Москва", 		TabAuthors[0], TabSections[0], "Масло, холст", "30x50", 20000),
                new Pictures(1005, "Пионы", 				TabAuthors[0], TabSections[1], "Масло, холст", "80x70", 50000),
                new Pictures(1006, "Таганский парк", 		TabAuthors[1], TabSections[0], "Акварель", "60x40", 25000)
        };
        List<Authors> AUT = new ArrayList<>();
        for (int i = 0; i < TabAuthors.length; i++)
        {
            AUT.add(i, TabAuthors[i]);
        }
        System.out.println("«Авторы»");
        for (Authors item : AUT)
        {
            System.out.println(item);
        }
        Authors setAUT = new Authors(102, "Лачугина Н.В.");
        System.out.println("Меняем элемент: " + AUT.get(2));
        System.out.println("Обновляем");
        AUT.set(2, setAUT);
        System.out.println("Измененный элемент: " + AUT.get(2));
        System.out.println("Удаляем элементы из списка");
        while (!AUT.isEmpty())
        {
            AUT.remove(0);
        }
        if (AUT.isEmpty()) System.out.println("Список пустой");

        System.out.println("\n«Разделы»");
        SortedSet<Sections> SEC = new TreeSet<Sections>();
        for (int i = 0; i < TabSections.length; i++)
        {
            SEC.add(TabSections[i]);
        }
        for (Sections item : SEC)
        {
            System.out.println(item);
        }
        Sections setSEC = new Sections(12, "Горы");
        if (SEC.contains(TabSections[0]) && SEC.contains(setSEC)) {
            System.out.println("Меняем элемент: " + TabSections[0]);
            SEC.remove(TabSections[0]);
            SEC.add(setSEC);
        } else System.out.println("Элемент не найден");
        System.out.println("Удаляем элементы из множества");
        Iterator<Sections> itSEC = SEC.iterator();
        while (itSEC.hasNext())
        {
            itSEC.next();
            itSEC.remove();
        }
        if (SEC.isEmpty()) System.out.println("Множество пустое");
        Map<Integer, Pictures> tb1 = new HashMap<Integer, Pictures>();
        for (int i = 0; i < TabPictures.length; i++)
        {
            tb1.put(i, TabPictures[i]);
        }
        System.out.println("\n«Картины»");
        for (Map.Entry<Integer, Pictures> item : tb1.entrySet())
        {
            System.out.println("Ключ: " + item.getKey() + " : Значение: " + item.getValue());
        }
        Pictures changeSet = new Pictures(1007, "ЮЖНЫЙ парк", 		TabAuthors[0], TabSections[0], "Акварель", "90x40", 100000);
        System.out.println("Произведем обновление записи с ключом 3: ");
        tb1.replace(3, changeSet);
        for (Map.Entry<Integer, Pictures> item : tb1.entrySet())
        {
            System.out.println("Ключ: " + item.getKey() + " : Значение: " + item.getValue());
        }
        System.out.println("Удаляем все записи из словаря: ");
        Iterator<Map.Entry<Integer, Pictures>> tb1Map = tb1.entrySet().iterator();
        while (tb1Map.hasNext())
        {
            tb1Map.next();
            tb1Map.remove();
        }
        if (tb1.isEmpty()) System.out.println("Словарь пуст");
    }
}




//////////////////////////////////////////////////////////////////////////////////////////////



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

class Authors
{
    private int idnumberauthors;
    private String fiopeoplerauthors;
    
    public int Getidnumberauthors() { return idnumberauthors; }
    Authors()
    {
        this.idnumberauthors = 0;
        this.fiopeoplerauthors = "NULL";        
    }
    Authors(int idnumberauthors)
    {
        this.idnumberauthors = idnumberauthors;
        this.fiopeoplerauthors = "NULL";        
    }
    Authors(int idnumberauthors, String fiopeoplerauthors)
    {
        this.idnumberauthors = idnumberauthors;
        this.fiopeoplerauthors = fiopeoplerauthors;       
    }
    @Override
    public String toString()
    {
        return idnumberauthors 
		+ " | " 
		+ fiopeoplerauthors;
    }
}

class Sections extends TreeSet<Sections> implements Comparable<Sections>
{
    private int idsectionsections;
    private String namesectionsections;
    public int Getidsectionsections() { return idsectionsections; }
    Sections()
    {
        this.idsectionsections = 0;
        this.namesectionsections = "NULL";      
    }
    Sections(int idsectionsections)
    {
        this.idsectionsections = idsectionsections;
    }
    Sections(int idsectionsections, String namesectionsections)
    {
        this.idsectionsections = idsectionsections;
        this.namesectionsections = namesectionsections;
    }
    @Override
    public int compareTo(Sections arg1)
    {
        return idsectionsections - arg1.Getidsectionsections();
    }
    @Override
    public String toString()
    {
        return idsectionsections 
		+ " | " 
		+ namesectionsections;
    }
}

class Pictures
{
    private int idpictures;
    private String namepictures;
	private Authors idnumberauthors;
    private Sections idsectionsections;
	private String technic;
	private String sizespictures;
	private int bitcoins;

    Pictures()
    {
        this.idpictures = 0;
		this.namepictures = "NULL";
        this.idnumberauthors = null;
        this.idsectionsections = null;
		this.technic = "NULL";
		this.sizespictures = "NULL";
		this.bitcoins = 0;
    }
    Pictures(int idpictures, String namepictures, Authors idnumberauthors, Sections idsectionsections, String technic, String sizespictures, int bitcoins)
    {
        this.idpictures = idpictures;
		this.namepictures = namepictures;
		this.idnumberauthors = idnumberauthors;
        this.idsectionsections = idsectionsections;
		this.technic = technic;
		this.sizespictures = sizespictures;
		this.bitcoins = bitcoins;
        
    }
    @Override
    public String toString()
    {
        return idpictures 
		+ " | " 
		+ namepictures 
		+ " | " 
		+ idnumberauthors.Getidnumberauthors()
		+ " | " 
		+ idsectionsections.Getidsectionsections() 
		+ " | "
		+ technic
		+ " | "
		+ sizespictures
		+ " | "
		+ bitcoins
		; 
    }
}
 

public class testmainclass {
	public static void main(String[] args) {
        Authors TabAuthors[] = {
                new Authors(100, "Крупень С."),
                new Authors(101, "Беляев Р.Х."),
                new Authors(103, "Кручинкин Ю."),
                new Authors(104, "Малевич П.") 
        };
        Sections TabSections[] = {
                new Sections(10, "Городской пейзаж"),
                new Sections(11, "Натюрморт")
        };
        Pictures TabPictures[] = {
                new Pictures(1001, "Даниловский монастырь",	TabAuthors[1], TabSections[0], "Пастель", "40x50", 40000),
                new Pictures(1002, "Весёлый денёк", 		TabAuthors[1], TabSections[1], "Масло, холст", "45x70", 15000),
                new Pictures(1003, "Старая Москва", 		TabAuthors[2], TabSections[0], "Акварель", "30x60", 12000),
                new Pictures(1004, "Старая Москва", 		TabAuthors[0], TabSections[0], "Масло, холст", "30x50", 20000),
                new Pictures(1005, "Пионы", 				TabAuthors[0], TabSections[1], "Масло, холст", "80x70", 50000),
                new Pictures(1006, "Таганский парк", 		TabAuthors[1], TabSections[0], "Акварель", "60x40", 25000)
        };
        List<Authors> AUT = new ArrayList<>();
        for (int i = 0; i < TabAuthors.length; i++)
        {
            AUT.add(i, TabAuthors[i]);
        }
        System.out.println("«Авторы»");
        for (Authors item : AUT)
        {
            System.out.println(item);
        }
        Authors setAUT = new Authors(102, "Лачугина Н.В.");
        System.out.println("Меняем элемент: " + AUT.get(2));
        System.out.println("Обновляем");
        AUT.set(2, setAUT);
        System.out.println("Измененный элемент: " + AUT.get(2));
        System.out.println("Удаляем элементы из списка");
        while (!AUT.isEmpty())
        {
            AUT.remove(0);
        }
        if (AUT.isEmpty()) System.out.println("Список пустой");

        System.out.println("\n«Разделы»");
        SortedSet<Sections> SEC = new TreeSet<Sections>();
        for (int i = 0; i < TabSections.length; i++)
        {
            SEC.add(TabSections[i]);
        }
        for (Sections item : SEC)
        {
            System.out.println(item);
        }
        Sections setSEC = new Sections(12, "Горы");
        if (SEC.contains(TabSections[0]) && SEC.contains(setSEC)) {
            System.out.println("Меняем элемент: " + TabSections[0]);
            SEC.remove(TabSections[0]);
            SEC.add(setSEC);
        } else System.out.println("Элемент не найден");
        System.out.println("Удаляем элементы из множества");
        rowIterator<Sections> itSEC = (rowIterator<Sections>) SEC.iterator();
        while (itSEC.hasNext())
        {
            itSEC.hasNext();
            itSEC.remove();
        }
        if (SEC.isEmpty()) System.out.println("Множество пустое");
        Map<Integer, Pictures> tb1 = new HashMap<Integer, Pictures>();
        for (int i = 0; i < TabPictures.length; i++)
        {
            tb1.put(i, TabPictures[i]);
        }
        System.out.println("\n«Картины»");
        for (Map.Entry<Integer, Pictures> item : tb1.entrySet())
        {
            System.out.println("Ключ: " + item.getKey() + " : Значение: " + item.getValue());
        }
        Pictures changeSet = new Pictures(1007, "ЮЖНЫЙ парк", 		TabAuthors[0], TabSections[0], "Акварель", "90x40", 100000);
        System.out.println("Произведем обновление записи с ключом 3: ");
        tb1.replace(3, changeSet);
        for (Map.Entry<Integer, Pictures> item : tb1.entrySet())
        {
            System.out.println("Ключ: " + item.getKey() + " : Значение: " + item.getValue());
        }
        System.out.println("Удаляем все записи из словаря: ");
        rowIterator<Map.Entry<Integer, Pictures>> tb1Map = (rowIterator<Entry<Integer, Pictures>>) tb1.entrySet().iterator();
        while (tb1Map.hasNext())
        {
            tb1Map.hasNext();
            tb1Map.remove();
        }
        if (tb1.isEmpty()) System.out.println("Словарь пуст");
    }
}

//////////////////



public class rowIterator<T> {

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
