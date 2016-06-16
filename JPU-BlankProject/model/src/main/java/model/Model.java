package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;



/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	private int height = 12;
	private int width = 21;

	public int getHeight(){
		return this.height;
	}

	public int getWidth(){
		return this.width;
	}

	public char map2D [][] = new char[this.getHeight()][this.getWidth()];

	/** The message. */
	private String message;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}
	public void rempmap(int i, int j, char carc){
		this.map2D[i][j] = carc;
	}

	public void  tabmap() {
		String[] maptab = this.message.split("\n");
		for(int i=0; i<maptab.length; i++)
		{
			for (int j=0; j<maptab[i].length(); j++)
			{
				switch ((maptab[i].charAt(j))){
					case'R':
						this.rempmap(i,j,'R');
						break;
					case'S':
						this.rempmap(i,j,'S');
						break;
					case'T':
						this.rempmap(i,j,'T');
						break;
					case'Q':
						this.rempmap(i,j,'Q');
						break;
					case'P':
						this.rempmap(i,j,'P');
						break;
					case'N':
						this.rempmap(i,j,'N');
						break;
					case'M':
						this.rempmap(i,j,'M');
						break;
					case'L':
						this.rempmap(i,j,'L');
						break;
					case'K':
						this.rempmap(i,j,'K');
						break;
					case'J':
						this.rempmap(i,j,'J');
						break;
					case'I':
						this.rempmap(i,j,'I');
						break;
					case'U':
						this.rempmap(i,j,'U');
						break;
					case'V':
						this.rempmap(i,j,'V');
						break;
					case'X':
						this.rempmap(i,j,'X');
						break;
					case'Y':
						this.rempmap(i,j,'Y');
						break;
					case'A':
						this.rempmap(i,j,'A');
						break;
				}
			}
		}
	}

	public char[][] getMap2D(){
		return this.map2D;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
