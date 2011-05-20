
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




KEYWORD_67 : 'implementation';

KEYWORD_66 : 'subcomponents';

KEYWORD_65 : 'connections';

KEYWORD_62 : 'properties';

KEYWORD_63 : 'prototypes';

KEYWORD_64 : 'subprogram';

KEYWORD_60 : 'parameter';

KEYWORD_61 : 'processor';

KEYWORD_56 : 'abstract';

KEYWORD_57 : 'features';

KEYWORD_58 : 'provides';

KEYWORD_59 : 'requires';

KEYWORD_45 : 'applies';

KEYWORD_46 : 'extends';

KEYWORD_47 : 'feature';

KEYWORD_48 : 'initial';

KEYWORD_49 : 'inverse';

KEYWORD_50 : 'package';

KEYWORD_51 : 'private';

KEYWORD_52 : 'process';

KEYWORD_53 : 'refined';

KEYWORD_54 : 'renames';

KEYWORD_55 : 'virtual';

KEYWORD_38 : 'access';

KEYWORD_39 : 'device';

KEYWORD_40 : 'memory';

KEYWORD_41 : 'public';

KEYWORD_42 : 'source';

KEYWORD_43 : 'system';

KEYWORD_44 : 'thread';

KEYWORD_32 : 'annex';

KEYWORD_33 : 'calls';

KEYWORD_34 : 'event';

KEYWORD_35 : 'flows';

KEYWORD_36 : 'group';

KEYWORD_37 : 'modes';

KEYWORD_24 : 'data';

KEYWORD_25 : 'flow';

KEYWORD_26 : 'mode';

KEYWORD_27 : 'none';

KEYWORD_28 : 'path';

KEYWORD_29 : 'port';

KEYWORD_30 : 'sink';

KEYWORD_31 : 'with';

KEYWORD_18 : '<->';

KEYWORD_19 : ']->';

KEYWORD_20 : 'all';

KEYWORD_21 : 'bus';

KEYWORD_22 : 'end';

KEYWORD_23 : 'out';

KEYWORD_11 : '->';

KEYWORD_12 : '-[';

KEYWORD_13 : '::';

KEYWORD_14 : '=>';

KEYWORD_15 : 'in';

KEYWORD_16 : 'of';

KEYWORD_17 : 'to';

KEYWORD_1 : '(';

KEYWORD_2 : ')';

KEYWORD_3 : ',';

KEYWORD_4 : '.';

KEYWORD_5 : ':';

KEYWORD_6 : ';';

KEYWORD_7 : '[';

KEYWORD_8 : ']';

KEYWORD_9 : '{';

KEYWORD_10 : '}';



RULE_EM : 'error_model';

RULE_ANNEXTEXT : '{**' ( options {greedy=false;} : . )*'**}';

RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



