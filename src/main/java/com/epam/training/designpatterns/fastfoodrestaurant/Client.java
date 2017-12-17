package com.epam.training.designpatterns.fastfoodrestaurant;

public class Client {

    public Order createOrder() {

        /*
        Kétféle hotdog és kétféle ketchup van:
        1. Az étlapon szereplő választási lehetőség, amit a Client egyszerűen Stringként ad meg
           - Ez így elég low level, nem segítenek típusok a rendelésben
           - A vendégnek ismernie kell a formátumot, amit a szakács értelmezni tud pl. extrák CSV formátumban
           - Viszont előnye, hogy a másik félnek nem kell ismernie a saját típust, csak a String típust, ami meg
             ott lesz minden JVM-en
           - 2 együttműködő osztály helyett gondolkozhatunk akár egy web app 2 rétegében is (2 Maven modulban) vagy
             akár 2 külön gépen futó szervizben vagy appban is, amik úgy kommunikálnak, hogy valamilyen módon
             szerializálják a küldött adatot. Java szerializációnál mindkét félnek ismernie kell a típust, különben
             a deszerializáció nem végezhető el, de pl. JSON szerializációnál egy String típusú mező nagyon rugalmas
             tud lenni.
             A projekten pont volt olyan, hogy toleránssá akartuk tenni a fogadó felet, ami azt jelenti, hogy csendben
             ignorálnia kell esetleg hiányzó fieldeket és nem szabad hibát dobnia. Ezt egyszerűen meg lehetett tenni
             a Jackson bekonfigurálásával. Akkor volt probléma, amikor enumot használtunk egy bizonyos mezőnél, mert
             annak a bővítése csak a küldő oldalon breaking change-t okozott a másikon. Nem volt nagy szükségünk arra,
             hogy ez a field enum legyen, kényelmi, szemantikai okból jött jól. Viszont mivel fontosabb volt, hogy ne
             törjük el a klienst az API fejlesztésével, átálltunk a "gyengébben típusos", nagyobb szabadságot adó
             Stringre.

        2. Maga az étel, amiből minden vendégnek külön példányt kell készíteni
            - Ezek saját Java osztályok, amik a Food interfész implementálják
        */
        return new Order(this, "hotdog", "ketchup");
    }
}
