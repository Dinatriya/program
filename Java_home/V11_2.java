package com.company;
class Authors
{
    private String kode_Author;
    private String fio_Author;
    private static String title;
    Authors(String s)
    {
        String r[] = s.split(", ");
        kode_Author = r[0];
        fio_Author = r[1];
    }
    @Override
    public String toString() {
        String out[] = title.split(", ");
        return "| " + out[0] + "|" + out[1] + "| ";
    }
    static void setTitle(String s)
    {
        title = s;
    }
    public static void Show(Authors s[])
    {
        System.out.println(s[0]);
        for (Authors a: s)
        {
            System.out.format("| %3s  |  %3s |\n", a.kode_Author, a.fio_Author);
        }
    }
}
class Books
{
    private String isbn;
    private String kode_Author_books;
    private String name_Book;
    private String price;
    static String title;
    Books(String s)
    {
        String[] r = s.split(", ");
        isbn = r[0];
        kode_Author_books = r[1];
        name_Book = r[2];
        price = r[3];
    }
    @Override
    public String toString() {
        String r[] = title.split(", ");
        return "| " + r[0] + " | " + r[1] + "|     " + r[2] + "|" + r[3] + " | ";
    }
    static void setTitle(String s)
    {
        title = s;
    }
    public static void Show(Books s[])
    {
        System.out.println(s[0]);
        for (Books a: s)
        {
            System.out.format("| %3s   |    %3s    |   %2s   | %3s    |\n", a.isbn, a.kode_Author_books, a.name_Book, a.price);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        String[] ObjAuthors = {
                "Код автора, ФИО автора",
                "01, Иванов Сергей Степанович",
                "02, Сидорова Ольга Юрьевна",
                "03, Петров Иван Петрович"

        };
        Authors.setTitle(ObjAuthors[0]);
        Authors arg1[] = new Authors[ObjAuthors.length - 1];
        for (int i = 0; i < arg1.length; i++) arg1[i] = new Authors(ObjAuthors[i + 1]);

        Authors.Show(arg1);
        String[] ObjBooks = {
                "ISBN, Код автора, Название книги, Цена(руб.)",
                "978-5-388-00003, 01, Самоучитель JAVA, 300",
                "978-5-699-58103, 02, JAVA за 21 день, 600",
                "758-3-004-87105, 03, Сопромат, 350",
                "758-3-057-37854, 01, Механика, 780",
                "675-3-423-00375, 03, Физика, 450"

        };
        Books.setTitle(ObjBooks[0]);
        Books arg2[] = new Books[ObjBooks.length - 1];
        for (int i = 0; i < arg2.length; i++) arg2[i] = new Books(ObjBooks[i + 1]);
        Books.Show(arg2);
    }
}
