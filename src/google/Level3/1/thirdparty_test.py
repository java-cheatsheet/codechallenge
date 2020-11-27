# https://docs.python.org/3/library/unittest.html

import unittest

def solution(M, F):
    x, y = int(M), int(F)
    
    if x == y and x == 1:
        return "0"
    
    if x == 1 or y == 1:
        if x > y:
            return str(x - 1)
        else:
            return str(y - 1)

    if x == y:
        return "impossible"
        
    if y > 1 and x > y and x % y == 0:
        return "impossible"
    
    if x > 1 and x < y and y % x == 0:
        return "impossible"

    count, q = 0, 0
    while y >= 1:
        if x < y:
            x, y = y, x
        x, y, q = y, x % y, x // y
        count += q
    return str(count - 1) if x == 1 else "impossible"
    
class TestSolution(unittest.TestCase):
    
    cases = [
        {'A': '1', 'B': '2', 'want':'1'},
        {'A': '2', 'B': '1', 'want':'1'},
        {'A': '4', 'B': '7', 'want':'4'},
        {'A': '2', 'B': '4', 'want': 'impossible'}, 
        {'A': '3', 'B': '8', 'want': '4'},        
        {'A': '3', 'B': '9', 'want': 'impossible'},
        {'A': '2', 'B': '6', 'want': 'impossible'},
        {'A': '8', 'B': '2', 'want': 'impossible'},
        {'A': '10', 'B': '2', 'want': 'impossible'},
        {'A': '7', 'B': '21', 'want': 'impossible'},
        {'A': '1', 'B': '1', 'want': '0'},
        {'A': '19', 'B': '137', 'want': '1'},
    ]

    def test_solution(self):
        for x in self.cases[11:]:
            got = solution(x['A'], x['B'])
            self.assertEqual( got, x['want'],
             'A:B '+ x['A']+':'+x['B']+'  | want:got '+ x['want']+':'+ got) 

    # def test_upper(self):
    #     self.assertEqual('foo'.upper(), 'FOO')

    # def test_isupper(self):
    #     self.assertTrue('FOO'.isupper())
    #     self.assertFalse('Foo'.isupper())

    # def test_split(self):
    #     s = 'hello world'
    #     self.assertEqual(s.split(), ['hello', 'world'])
    #     # check that s.split fails when the separator is not a string
    #     with self.assertRaises(TypeError):
    #         s.split(2)

if __name__ == '__main__':
    unittest.main()


# var gcdData = []struct {
# 	description string
# 	a           int
# 	b           int
# 	want        int
# 	err         string
# }{
# 	{
# 		description: "GCD of 2 and 6",
# 		a:           2,
# 		b:           6,
# 		want:        2,
# 		err:         "",
# 	},
# 	{
# 		description: "GCD of 2 and 4",
# 		a:           2,
# 		b:           4,
# 		want:        2,
# 		err:         "",
# 	},
# 	{
# 		description: "GCD of 1 and 5",
# 		a:           5,
# 		b:           1,
# 		want:        1,
# 		err:         "",
# 	},
# 	{
# 		description: "GCD of 10 and 4",
# 		a:           10,
# 		b:           4,
# 		want:        2,
# 		err:         "",
# 	},
# 	{
# 		description: "GCD of 15 and 75",
# 		a:           15,
# 		b:           75,
# 		want:        15,
# 		err:         "",
# 	},
# }
