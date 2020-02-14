grammar Calculator;

POW: '^';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
NUMBER: [0-9]+;
WHITESPACE: [ \r\n\t]+ -> skip;

start : expression EOF;

expression
   : NUMBER                     # Number
   | '(' expression ')'         # Parentheses
   | expression POW expression  # Power
   | expression MUL expression  # Multiplication
   | expression DIV expression  # Division
   | expression ADD expression  # Addition
   | expression SUB expression  # Subtraction
   ;
