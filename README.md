# pwdman - Password manager

## 1 Kirjeldus
pwdman aitab hallata kõikvõimalikke kontosid turvaliselt. Programm koosneb:
* Login aknast (GridPane), kus toimub kasutaja autentimine ja baasiga ühenduse loomine/uue baasi 
loomine;
* Main aknast (BorderPane), kus kuvatakse vasakul ääres andmebaasi puu, mis koosneb kontode 
gruppidest ja 
nende all omakorda kontode loend. Otse puus saab luua uut gruppi ja kontot, muuta olemasolevaid 
ja kustutada. Kontode grupil vajutades, kuvatakse BorderPane keskmises regioonis selles grupis 
olevate kontode loend: Account name, User Name, Password, URL, Notes. Vajutades kontol, kuvatakse keskmises regioonis konto vorm, 
kus näeb kogu infot konto kohta ja seda redigeerida. Lisaks, alumises regioonis 
kuvatakse statistiline info konto kohta: millal loodud, millal viimati muudetud, parooli loomise 
kuupäev, parooli aegumise aeg jne. Kogu info fetchitakse andmebaasist;
* Andmebaasina kasutatakse SQLite'i.

## 2 Nõuded rakendusele
* Programm on kaitstud master passwordiga;
* Andmebaas on krüpteeritud;
* Samaaegselt saab avada mitu andmebaasi puud (menüü ribalt saab avada uue andmebaasi faili, luua uut baasi ja sinna 
  importida CSV-st andmed). Olemasolevat andmebaasi saab eksportida CSV-sse.

## 3 Edasiarendus
* Parooli keerukuse kontroll;
* Random parooli genereerimise võimalus;
* Parooli vahetamise meeldetuletus meilile;
* Lisada erinevat funktsionaalsust.

## 4 Grand finale
* Apliktasioonist teha webapp.

## 5 Visioon
Kõik, kellel on kodus Synology NAS või QNAP, saavad ise hostida oma veebipõhist password manageri.

## 6 Litsents
Licensed under  GNU General Public License Version 3 (GPLv3) 

