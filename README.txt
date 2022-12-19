1. Omówienie Algorytmu
W algorytmie zastosowano 3 klasy:
• Czytelnik – klasa reprezentująca czytelnika
• Pisarz – klasa reprezentująca pisarza
• Czytelnia – klasa reprezentująca czytelnię
Każdy czytelnik i pisarz dziedziczy po klasie Thread. W obu klasach zaimplementowano metodę run(), której
zadaniem jest symulacja dostępu do czytelni. Obie klasy mają dostęp do odpowiednich metod request() i finish()
klasy Czytelnia, które reprezentują odpowiednio żądanie dostępu do czytelni i zakończenie dostępu do czytelni.
Dostępem do czytelni zarządzają 3 semafory:
• S1 – queue, który chroni dostęp i stanowi coś w rodzaju kolejki do czytelni
• S2 – readerSemaphore, który zardądza dostępem czytelników do czytelni
• S3 – writerSemaphore, który zardądza dostępem piszrzy do czytelni

2. Sposób uruchomienia programu
Program uruchamia się z poziomu konsoli. Będąc w odpowiednim katalogu w konsoli należy wpisać komendę:
java -jar CzytelnicyPisarze-1.0-SNAPSHOT.jar

3. Opis komunikatów wyświetlanych przez program
Program wyświetla komunikaty w konsoli. Komunikaty te są wyświetlane w 3 przypadkach:
• Po zażądaniu dostępu do czytelni przez czytelnika lub pisarza
    "[reader/writer] [id] wants to [read/write]"
• Po uzyskaniu dostępu do czytelni przez czytelnika lub pisarza
    "[reader/writer] [id] is [reading/writing]"
• Po opuszczniu czytelni przez czytelnika lub pisarza
    "[reader/writer] [id] finished [reading/writing]"
Komunikaty dotyczące pisarzy są wyświetlane dużymi literami.

4. Inne istotne informacje

4.1 Ilość czytelników i pisarzy
Ilość czytelników i pisarzy jest ustalana w klasie ReaderWriter w linijkach 16 i 20. Wartosci te wynoszą domyślnie
10 czytelników i 3 pisarzy. Wartości te można zmienić w kodzie źródłowym.

4.2 Czasy oczekiwania
Długość czasów oczekiwania są ustalane odpowiednio w klasach Reader i Writer w linijkach 36 i 36. Wartości te można
zmienić w kodzie źródłowym (są tam wyrażane w milisekundach). Domyślnie wynoszą one:
Czasy dostępu do zasobu (czas przebywania w czytelni):
• Czytelnik – 1 sekunda
• Pisarz – 3 sekundy
Czasy oczekiwanie przed ponowną próbą dostępu:
• Czytelnik – 3 sekundy
• Pisarz – 10 sekund

