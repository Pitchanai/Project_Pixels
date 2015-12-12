package shape;

import java.awt.Color;

public class Blocks {
	private int blockStatus;
	private Color blockColor; 
	
	private int blockStatusTemp;
	private Color blockColorTemp;

	public static final int BLANK = 0;
	public static final int FILLED = 1;
	public static final int WILL_BE_DELETED = 2;
	public static final int FILLED_IN_SHAPE = 3;
	public static final int CAN_FILL = 4;
	public static final int CANT_FILL = 5;
	
	public Blocks(int blockStatus, Color blockColor) {
		this.blockStatus = blockStatus;
		this.blockColor = blockColor;
		if (blockStatus == BLANK) 
			this.blockColor = Color.LIGHT_GRAY;
	}

	public int getBlockStatus() {
		return blockStatus;
	}

	public Color getBlockColor() {
		return blockColor;
	}
	
	public void setBlock(int blockStatus, Color blockColor) {
		if (blockStatus == BLANK) {
			this.blockStatus = BLANK;
			this.blockColor = Color.LIGHT_GRAY;
			return;
		} else {
			this.blockStatus = blockStatus;
			this.blockColor = blockColor;
		}
	}
	
	public void setBlank() {
		this.blockStatus = BLANK;
		this.blockColor = Color.LIGHT_GRAY;
	}
	
	public void setCanFill() {
		this.blockColorTemp = this.blockColor;
		this.blockStatusTemp = this.blockStatus;
		this.blockStatus = CAN_FILL;
		this.blockColor = Color.PINK;
	}
	
	public void undoCanFill() {
		if (blockStatus == CAN_FILL) {
			this.blockColor = this.blockColorTemp;
			this.blockStatus = this.blockStatusTemp;
		} else 
			return;
	}

}
