def isFinished():
    return counter == 0;

def countDown():
    if not isFinished():
        global counter
        counter -= 1
        print('Teller ned med 1, nå er det',counter)
        
counter = 4
countDown()
print(isFinished())
countDown()
print(isFinished())
countDown()
print(isFinished())
countDown()
print(isFinished())
countDown()
print(isFinished())
