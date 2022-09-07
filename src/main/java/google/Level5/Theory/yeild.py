def printer():
    while True:
        data = yield
        print("Processing", data)
  
def printer_wrapper(gen):
    yield from gen
  
pr = printer_wrapper(printer())
 
# Below code to avoid TypeError: can't send non-None value to a just-started generator
pr.send(None)
 
for x in range(1, 5):
    pr.send(x)