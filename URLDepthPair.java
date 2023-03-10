package com.company;

import java.util.LinkedList;
import java.net.MalformedURLException;
import java.net.URL;

//Класс для представления пар ссылка, глубина для нашего искателя.
public class URLDepthPair {

    //Поля для представления константы, текущего URL-адреса и текущей глубины.
    private static final String URL_PREFIX = "https://"; // Строковая константа
    private String URLString;
    private int depth;

    //Конструктор, который устанавливает входные данные на текущий URL-адрес и глубину.
    public URLDepthPair (String URL, int depth){
        this.URLString=URL;
        this.depth=depth;
    }

    //Метод, который возвращает веб-хост текущего URL-адреса.
    public String getHost() throws MalformedURLException {
        URL host = new URL(URLString);
        return host.getHost();
    }

    //Метод для получения пути
    public String getPath() throws MalformedURLException {
        URL path = new URL(URLString);
        return path.getPath();
    }

    //Метод, который возвращает текущую глубину.
    public int getDepth() {
        return depth;
    }

    //Метод, который возвращает текущий URL-адрес.
    public String getURL() {
        return URLString;
    }

    //Метод для префикса URL
    public String getURLPrefix() {
        return URL_PREFIX;
    }

    //Проверяет, был ли уже найден URL-адрес
    public static boolean check(LinkedList<URLDepthPair> resultLink, URLDepthPair pair) {
        boolean hasBeenChecked = true;
        for (URLDepthPair c : resultLink) {
            if (c.getURL().equals(pair.getURL())) hasBeenChecked = false;
        }
        return hasBeenChecked;
    }
}
