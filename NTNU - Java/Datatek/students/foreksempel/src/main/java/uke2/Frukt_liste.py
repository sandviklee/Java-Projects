# Slik kunne en eksamensoppgave i hvordan en skal håndtere flere
# frukt vært, i ITGK. Eksempelet tilsvarer ikke HELT det jeg laget
# i Frukt.java, men det er mer for å få frem et prinsipp.
# Den er også veldig enkel, og kan lett brekke. ;-)

def finn_antall(liste, frukt):
    for type, antall in liste:
        if type == frukt:
            return antall
    return 0

def legg_til_frukt(liste, frukt, antall):
    for i in range(len(liste)):
        type = liste[i][0]
        print("type:",type)
        if type == frukt:
            liste[i][1] += antall
            return liste # Funnet og endret. Ferdig!
    liste.append([frukt, antall]) # frukt finnes ikke fra før
    return liste # Med ny type

liste = []
print(f'Paprika: {finn_antall(liste,"paprika")}')
liste = legg_til_frukt(liste,"paprika",2)
print(f'Paprika: {finn_antall(liste,"paprika")}')
list = legg_til_frukt(liste,"paprika",2)
print(f'Paprika: {finn_antall(liste,"paprika")}')
liste = legg_til_frukt(liste,"ananas",1)
print(f'Nananananas: {finn_antall(liste,"ananas")}')

print(liste)

# Men hadde det ikke vært kult om vi kunne lage egne fruktobjekter,
# som husker hvor mange det er av dem?
