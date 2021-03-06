package org.kframework.kagreg;

import org.kframework.kil.Cell;
import org.kframework.kil.ASTNode;
import org.kframework.kil.loader.Context;
import org.kframework.kil.visitors.CopyOnWriteTransformer;
import org.kframework.kil.visitors.exceptions.TransformerException;

public class RenameCellsTransformer extends CopyOnWriteTransformer {
	protected RenameStrategy renameStrategy;

	public RenameCellsTransformer(RenameStrategy renameStrategy, Context context) {
		super("RenameCellsTransformer", context);
		this.renameStrategy = renameStrategy;
		assert this.renameStrategy != null;
	}
	
	@Override
	public ASTNode transform(Cell cell) throws TransformerException {
		//assert cell.getLabel().equals(cell.getEndLabel());
		//System.out.println("found cell " + cell.getLabel() + " - " + cell.getEndLabel());
		cell = (Cell)super.transform(cell);
		String oldName = cell.getLabel();
		String oldNameEnd = cell.getEndLabel();
		if (oldName != null) {
			cell.setLabel(renameStrategy.getNewName(oldName));
		}
		if (oldNameEnd != null) {
			cell.setEndLabel(renameStrategy.getNewName(oldNameEnd));
		}
		return cell;
	}
}
