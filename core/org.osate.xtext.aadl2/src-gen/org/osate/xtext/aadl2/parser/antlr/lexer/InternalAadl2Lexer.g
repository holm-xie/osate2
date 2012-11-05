
/*
* generated by Xtext
*/
lexer grammar InternalAadl2Lexer;


@header {
package org.osate.xtext.aadl2.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}




KEYWORD_98 : ('I'|'i')('M'|'m')('P'|'p')('L'|'l')('E'|'e')('M'|'m')('E'|'e')('N'|'n')('T'|'t')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

KEYWORD_97 : ('S'|'s')('U'|'u')('B'|'b')('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('N'|'n')('E'|'e')('N'|'n')('T'|'t')('S'|'s');

KEYWORD_93 : ('A'|'a')('A'|'a')('D'|'d')('L'|'l')('B'|'b')('O'|'o')('O'|'o')('L'|'l')('E'|'e')('A'|'a')('N'|'n');

KEYWORD_94 : ('A'|'a')('A'|'a')('D'|'d')('L'|'l')('I'|'i')('N'|'n')('T'|'t')('E'|'e')('G'|'g')('E'|'e')('R'|'r');

KEYWORD_95 : ('C'|'c')('O'|'o')('N'|'n')('N'|'n')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

KEYWORD_96 : ('E'|'e')('N'|'n')('U'|'u')('M'|'m')('E'|'e')('R'|'r')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

KEYWORD_88 : ('A'|'a')('A'|'a')('D'|'d')('L'|'l')('S'|'s')('T'|'t')('R'|'r')('I'|'i')('N'|'n')('G'|'g');

KEYWORD_89 : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')('I'|'i')('F'|'f')('I'|'i')('E'|'e')('R'|'r');

KEYWORD_90 : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('I'|'i')('E'|'e')('S'|'s');

KEYWORD_91 : ('P'|'p')('R'|'r')('O'|'o')('T'|'t')('O'|'o')('T'|'t')('Y'|'y')('P'|'p')('E'|'e')('S'|'s');

KEYWORD_92 : ('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m');

KEYWORD_84 : ('P'|'p')('A'|'a')('R'|'r')('A'|'a')('M'|'m')('E'|'e')('T'|'t')('E'|'e')('R'|'r');

KEYWORD_85 : ('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s')('O'|'o')('R'|'r');

KEYWORD_86 : ('P'|'p')('R'|'r')('O'|'o')('T'|'t')('O'|'o')('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

KEYWORD_87 : ('R'|'r')('E'|'e')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

KEYWORD_77 : ('A'|'a')('A'|'a')('D'|'d')('L'|'l')('R'|'r')('E'|'e')('A'|'a')('L'|'l');

KEYWORD_78 : ('A'|'a')('B'|'b')('S'|'s')('T'|'t')('R'|'r')('A'|'a')('C'|'c')('T'|'t');

KEYWORD_79 : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('T'|'t');

KEYWORD_80 : ('F'|'f')('E'|'e')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('E'|'e')('S'|'s');

KEYWORD_81 : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('Y'|'y');

KEYWORD_82 : ('P'|'p')('R'|'r')('O'|'o')('V'|'v')('I'|'i')('D'|'d')('E'|'e')('S'|'s');

KEYWORD_83 : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('S'|'s');

KEYWORD_63 : ('A'|'a')('P'|'p')('P'|'p')('L'|'l')('I'|'i')('E'|'e')('S'|'s');

KEYWORD_64 : ('B'|'b')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('N'|'n')('G'|'g');

KEYWORD_65 : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('U'|'u')('T'|'t')('E'|'e');

KEYWORD_66 : ('E'|'e')('X'|'x')('T'|'t')('E'|'e')('N'|'n')('D'|'d')('S'|'s');

KEYWORD_67 : ('F'|'f')('E'|'e')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('E'|'e');

KEYWORD_68 : ('I'|'i')('N'|'n')('H'|'h')('E'|'e')('R'|'r')('I'|'i')('T'|'t');

KEYWORD_69 : ('I'|'i')('N'|'n')('I'|'i')('T'|'t')('I'|'i')('A'|'a')('L'|'l');

KEYWORD_70 : ('I'|'i')('N'|'n')('V'|'v')('E'|'e')('R'|'r')('S'|'s')('E'|'e');

KEYWORD_71 : ('P'|'p')('A'|'a')('C'|'c')('K'|'k')('A'|'a')('G'|'g')('E'|'e');

KEYWORD_72 : ('P'|'p')('R'|'r')('I'|'i')('V'|'v')('A'|'a')('T'|'t')('E'|'e');

KEYWORD_73 : ('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

KEYWORD_74 : ('R'|'r')('E'|'e')('F'|'f')('I'|'i')('N'|'n')('E'|'e')('D'|'d');

KEYWORD_75 : ('R'|'r')('E'|'e')('N'|'n')('A'|'a')('M'|'m')('E'|'e')('S'|'s');

KEYWORD_76 : ('V'|'v')('I'|'i')('R'|'r')('T'|'t')('U'|'u')('A'|'a')('L'|'l');

KEYWORD_55 : ('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

KEYWORD_56 : ('D'|'d')('E'|'e')('V'|'v')('I'|'i')('C'|'c')('E'|'e');

KEYWORD_57 : ('M'|'m')('E'|'e')('M'|'m')('O'|'o')('R'|'r')('Y'|'y');

KEYWORD_58 : ('P'|'p')('U'|'u')('B'|'b')('L'|'l')('I'|'i')('C'|'c');

KEYWORD_59 : ('R'|'r')('E'|'e')('C'|'c')('O'|'o')('R'|'r')('D'|'d');

KEYWORD_60 : ('S'|'s')('O'|'o')('U'|'u')('R'|'r')('C'|'c')('E'|'e');

KEYWORD_61 : ('S'|'s')('Y'|'y')('S'|'s')('T'|'t')('E'|'e')('M'|'m');

KEYWORD_62 : ('T'|'t')('H'|'h')('R'|'r')('E'|'e')('A'|'a')('D'|'d');

KEYWORD_45 : ('A'|'a')('N'|'n')('N'|'n')('E'|'e')('X'|'x');

KEYWORD_46 : ('C'|'c')('A'|'a')('L'|'l')('L'|'l')('S'|'s');

KEYWORD_47 : ('D'|'d')('E'|'e')('L'|'l')('T'|'t')('A'|'a');

KEYWORD_48 : ('E'|'e')('V'|'v')('E'|'e')('N'|'n')('T'|'t');

KEYWORD_49 : ('F'|'f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');

KEYWORD_50 : ('F'|'f')('L'|'l')('O'|'o')('W'|'w')('S'|'s');

KEYWORD_51 : ('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p');

KEYWORD_52 : ('M'|'m')('O'|'o')('D'|'d')('E'|'e')('S'|'s');

KEYWORD_53 : ('R'|'r')('A'|'a')('N'|'n')('G'|'g')('E'|'e');

KEYWORD_54 : ('U'|'u')('N'|'n')('I'|'i')('T'|'t')('S'|'s');

KEYWORD_33 : ('D'|'d')('A'|'a')('T'|'t')('A'|'a');

KEYWORD_34 : ('F'|'f')('L'|'l')('O'|'o')('W'|'w');

KEYWORD_35 : ('L'|'l')('I'|'i')('S'|'s')('T'|'t');

KEYWORD_36 : ('M'|'m')('O'|'o')('D'|'d')('E'|'e');

KEYWORD_37 : ('N'|'n')('O'|'o')('N'|'n')('E'|'e');

KEYWORD_38 : ('P'|'p')('A'|'a')('T'|'t')('H'|'h');

KEYWORD_39 : ('P'|'p')('O'|'o')('R'|'r')('T'|'t');

KEYWORD_40 : ('S'|'s')('E'|'e')('L'|'l')('F'|'f');

KEYWORD_41 : ('S'|'s')('I'|'i')('N'|'n')('K'|'k');

KEYWORD_42 : ('T'|'t')('R'|'r')('U'|'u')('E'|'e');

KEYWORD_43 : ('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

KEYWORD_44 : ('W'|'w')('I'|'i')('T'|'t')('H'|'h');

KEYWORD_23 : '*''*''}';

KEYWORD_24 : '+''=''>';

KEYWORD_25 : '<''-''>';

KEYWORD_26 : ']''-''>';

KEYWORD_27 : ('A'|'a')('L'|'l')('L'|'l');

KEYWORD_28 : ('B'|'b')('U'|'u')('S'|'s');

KEYWORD_29 : ('E'|'e')('N'|'n')('D'|'d');

KEYWORD_30 : ('O'|'o')('U'|'u')('T'|'t');

KEYWORD_31 : ('S'|'s')('E'|'e')('T'|'t');

KEYWORD_32 : '{''*''*';

KEYWORD_14 : '-''>';

KEYWORD_15 : '-''[';

KEYWORD_16 : '.''.';

KEYWORD_17 : ':'':';

KEYWORD_18 : '=''>';

KEYWORD_19 : ('I'|'i')('N'|'n');

KEYWORD_20 : ('I'|'i')('S'|'s');

KEYWORD_21 : ('O'|'o')('F'|'f');

KEYWORD_22 : ('T'|'t')('O'|'o');

KEYWORD_1 : '(';

KEYWORD_2 : ')';

KEYWORD_3 : '*';

KEYWORD_4 : '+';

KEYWORD_5 : ',';

KEYWORD_6 : '-';

KEYWORD_7 : '.';

KEYWORD_8 : ':';

KEYWORD_9 : ';';

KEYWORD_10 : '[';

KEYWORD_11 : ']';

KEYWORD_12 : '{';

KEYWORD_13 : '}';



RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

RULE_INTEGER_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* ('#' RULE_BASED_INTEGER '#' RULE_INT_EXPONENT?|RULE_INT_EXPONENT?);

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_IDANNEXTEXT : RULE_ID RULE_ANNEXTEXT;

RULE_ANNEXTEXT : '{**' ( options {greedy=false;} : . )*'**}';

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_WS : (' '|'\t'|'\r'|'\n')+;



