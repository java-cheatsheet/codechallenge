import base64
from itertools import cycle

message = input("Enter the encrypted message: ")

key = bytes(input("Enter your Google username: "), "utf8")

print(bytes(a ^ b for a, b in zip(base64.b64decode(message), cycle(key))))