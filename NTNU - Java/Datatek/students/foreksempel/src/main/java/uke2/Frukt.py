'''
Et eksempel på hvordan en kan lage klasser i Python.
Det gjør akkurat det samme som Frukt.java. Nesten.
Konstruktøren sier noe om hva slags parametre/verdier en må ha
for å kunne lage en ny frukt. getAntall og getType er metoder
som 'hører til' i Frukt. Se innrykket.
Når man har laget en Frukt kan man kalle disse metodene,
akkurat slik man kunne lage en liste og kalle liste.append().

'''

class Frukt:
        
    # Dette er konstruktøren i Python.
    def __init__(self, type, antall):
        self.type = type
        self.antall = antall
        
    # Disse metodene hører hjemme i Frukt. Slik ser det omtrent ut i Java også.
    def getAntall(self): # At en må ha med seg selv som parameter er bare sånn.
        return self.antall
    
    def getType(self):
        return self.type

    def legg_til(self,antall):
        self.antall += antall 


# Mens en i Java må bruke Frukt f1 = new Frukt("Appelsin", 2)
f1 = Frukt('Appelsin', 2)    
f2 = Frukt('Banan',1)
print("Først skriver vi ut typene til objektene:")
print(f1)
print(f2)
print('Så skriver vi innholdet i dem:')
print(f1.getType(),":",f1.getAntall())
print(f2.getType(),":",f2.getAntall())

# Legge til en banan:
f2.legg_til(1)
print(f2.getType(),":",f2.getAntall())

