
# Miniproject 1

Tyckte uppgiften blev ganska lätt eftersom man redan hade kod att testa, det var inte svårt att få 100% coverage och att hitta på tester som skulle nå alla delar av set_currentType() till exempel. Hade verkligen velat testa att först börja med testerna i blindo.
 
De viktigaste testen är att user input inte krashar programmet och att trianglarna är korrekt kategoriserade och inte omöjliga trianglar som inte kan existera.

Utifrån koden så går det inte att testa throws, för returvärdet blir null

Jag skulle gissa att man säkert behöver fler tester på att trianglarna är korrekta, men svårt att avgöra hur många tester man vill ha på trianglar. 

Jag visste inte riktigt om jag behövde testa upperbound med Integer.MAX_VALUE för likbenta trianglar kommer ge resultatet att det inte är en trianglen. Anledningen är att man adderar två sidor som overflowar.



