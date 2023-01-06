from random import randint
def code_generator():
   code = ""
   for i in range(7):
      i = chr(randint(97,122))
      code = str(code) + i
   return code

v = code_generator()
print (v)