/*
 * generated by Xtext
 */
package org.osate.categories.formatting

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import com.google.inject.Inject
import org.osate.categories.services.CategoriesGrammarAccess
import org.eclipse.xtext.Keyword;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class CategoriesFormatter extends AbstractDeclarativeFormatter {

	@Inject extension CategoriesGrammarAccess

	override protected void configureFormatting(FormattingConfig c) {

		// It's usually a good idea to activate the following three statements.
		// They will add and preserve newlines around comments
		c.setAutoLinewrap(120);
		c.setWrappedLineIndentation(2);
		c.setLinewrap(0, 1, 2).before(SL_COMMENTRule)
		c.setLinewrap(0, 1, 2).before(ML_COMMENTRule)
		c.setLinewrap(0, 1, 1).after(ML_COMMENTRule)
		for (pair : findKeywordPairs("[", "]")) {
			c.setIndentationIncrement().after(pair.first);
			c.setLinewrap().after(pair.first);
			c.setIndentationDecrement().before(pair.second);
			c.setLinewrap().before(pair.second);
		}
		c.setLinewrap().before(verificationCategoryRule);
		c.setLinewrap().before(requirementCategoryRule);
		c.setLinewrap().before(selectionCategoryRule);
	}
}