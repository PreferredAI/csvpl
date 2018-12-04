import os.path
import os
import re

CODE_PATTERN = re.compile(r'.+main.+?{(.+)}.+}', re.S)

def begin_section(name):
  m = 23 - int(len(name) / 2)
  padding = '=' * m
  result = padding + ' ' + name + ' ' + padding
  if len(result) % 2 == 0:
    result += '='
  print(result)

def end_section():
  print('=' * 49)

def main():
  exercise_dir = '../src/main/java/ai/preferred/regression/exercise/'
  for fn in os.listdir(exercise_dir):
    if fn.startswith('E') and not fn.startswith('E20'):
      name = fn.split('.')[0]
      begin_section(name)
      with open(os.path.join(exercise_dir, fn), 'r', encoding='utf8') as f:
        m = CODE_PATTERN.search(f.read())
        if m:
          print()
          print('public static void main(String[] args) {')
          print(m.group(1).strip(' '))
          print('}')
          print()
      end_section()
      print()
      print()

if __name__ == '__main__':
  main()

