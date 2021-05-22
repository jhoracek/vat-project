## Zadání

Naprogramujte aplikaci v&nbsp;Javě, která vypíše všechny státy Evropské unie, které mají sazbu daně z&nbsp;přidané hodnoty (DPH, VAT) vyšší, než 20&nbsp;% a&nbsp;nepoužívají speciální sazbu DPH/VAT.

Aktuální data o&nbsp;jednotlivých státech a&nbsp;jejich daních dostanete v&nbsp;souboru &mdash; vzorový soubor je ke stažení zde: [vat-eu.csv](vat-eu.csv).

Vstupní soubor bude ve stejné složce, jako projekt aplikace.

## Formát vstupního souboru

Na každém řádku vstupního souboru jsou informace o&nbsp;jednom státu v&nbsp;následujícím formátu:

- zkratka státu (například `AT`)

- název státu (`Austria`)

- plná sazba daně z&nbsp;přidané hodnoty v&nbsp;procentech (`20`)

- snížená sazba daně z&nbsp;přidané hodnoty v&nbsp;procentech (`10`)

- informace o&nbsp;tom, jestli země používá speciální sazbu DPH pro některé produkty (`true`/`false`)

Jednotlivé hodnoty jsou odděleny vždy tabulátorem.

Příklad několika řádků souboru:
```
AT	Austria	20	10	true
BE	Belgium	21	12	true
BG	Bulgaria	20	9	false
CY	Cyprus	19	9	false
CZ	Czech Republic	21	15	false
```

## Výstup aplikace

Postupně zpracujte tyto kroky:

1. Vypište seznam všech států a&nbsp;u&nbsp;každého uveďte základní sazbu daně z&nbsp;přidané hodnoty ve formátu:

    ```
    Název země (zkratka): základní sazba %
    ```
   Například:
    ```
    Austria (AT): 20 %
    Belgium (BE): 21 %
    ...
    ```

2. Vypište ve stejném formátu pouze státy, které mají základní sazbu daně z&nbsp;přidané hodnoty vyšší než 20&nbsp;% a&nbsp;přitom nepoužívají speciální sazbu daně.

3. Výpis seřaďte podle výše základní sazby DPH/VAT sestupně (nejprve státy s&nbsp;nejvyšší sazbou).

4. Pod výpis doplňte řádek s&nbsp;rovnítky pro oddělení a&nbsp;poté seznam zkratek států, které ve výpisu nefigurují.

   Například:
    ```
    Sweden (SE):    25 %
    Croatia (HR):   25 %
    ...
    Finland (FI):   24 %
    ...
    ====================
    Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: AT, CY, CZ,... 
    ```


5. Výsledný výpis kromě zapište i&nbsp;do souboru s&nbsp;názvem `vat-over-20.txt`, který uložíte do stejné složky, ve které byl vstupní soubor.

6. Doplňte možnost, aby uživatel z&nbsp;klávesnice zadal výši sazby DPH/VAT, podle které se má filtrovat.
    - Pokud uživatel zmáčkne pouze Enter, jako výchozí hodnota se použije sazba 20 %.
    - Upravte název výstupního souboru tak, aby reflektoval zadanou sazbu daně.