# fast-food-restaurant
'Fast Food Restaurant' Homework for the Design Patters 2017 Q4 Course

## Build and run

Buildelés: `mvn clean install`

Futtatás: `java -jar target/fastfoodrestaurant-0.0.1-SNAPSHOT.jar`

Fontos, hogy a pom.xml-ben a következő érték helyes legyen: ` <mainClass>com.epam.training.designpatterns.fastfoodrestaurant.Application</mainClass>`

## A feladat

Simulate the workflow of a restaurant.

#### Workflow
- Client orders a product
- The orders are prepared by a robot one after another (FIFO)
- The client receives and consumes the products

#### Products
- The restaurant sells hot dogs and chips
- Extras for the products: ketchup, mustard
- Hot dog increases client happiness by 2
- Chips increases client happiness by 5%
- Ketchup doubles the effect of a product
- Mustard increases client happiness by 1 and removes the effect of the product
- We will introduce new products and extras (with different effects) in the near future

#### Other informations
- We don’t expect other changes in the future
- Hand in (Github or email): 1. Source code 2. Tests 3. For each design pattern - Where did you use it and why (readme.md fájlba vagy külön text fájlba rövid indoklás és/vagy code review alatt kommentekben)

## Megjegyzések

Az ide illő tervezési minták megtalálásán kívül fontos, hogy a feladatot kellően kis részfeladatokra bontsuk le, hogy ne vesszünk el a komplexitásban.

Javaslom, hogy egy félig elkészült csillagromboló helyett úgy haladjatok, hogy lépésekben készüljön el egy-egy működő változat. Az első még lehet nagyon buta, aztán haladtok majd a kifinomultabb megoldások felé.

Egy **_lehetséges_** lebontás:
1. Egy vendég egy egyszerű ételre szóló rendelést tud csinálni. Ezt odaadja a szakácsnak, aki elkészíti az egyszerű ételt és odaadja a vendégnek.
2. Az étel hat a vengégre.
3. A pultos közvetít a vendég és a szakács között. A szakácsnak közvetlenül odaadja a rendelést, a vendégnek pedig az ételt. (metódushívás / mediator)
4. A vendég extrákat is kérhet az ételbe, a szakács beleteszi azokat a rendelés alapján.
5. Az extrák hatnak a vendégre.
6. A pultos szól a vengégeknek, amikor kész az étel. (event / observer)
7. A pultos egy fifoba teszi a rendeléseket, ahonnan a szakács kiveszi, de még kívülről utasítják rá. (Az Application main() metódusából, egyébként innen indítunk minden műveletet, nincsenek szálak, nincs aszinkron működés, nem pattan ki egyszer csak a rendelés a vendég fejéből). Amikor kész az étel, ugyanúgy odaadja a pultosnak, az meg a vendégnek.
8. Több vendég rendelhet egymás után, a szakácsot továbbra is utasítjuk, hogy vegyen el a fifoból.
9. A szakács magától vesz ki a fifoból, amikor ideje van. (külön szál a szakácsban) VAGY a fifo eventet küld a szakácsnak, ha rendelést tesznek bele.
10. A fifo szálbiztos (Google -> "java synchronized queue").
11. A vengégek aszinkronná válnak, random időnként rendelnek.

Bizonyos pontok sorrendje cserélhető és nem is kell eljutni a végéig. A felsorolt pontok 2/3-ával körülbelül elkészül a feladat.

Jó szórakozást!
