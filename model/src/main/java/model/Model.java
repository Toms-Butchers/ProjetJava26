package model;

import java.sql.SQLException;

import java.util.Observable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.IModel;


/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	private int height = 12;
	private int width = 21;
	private Hero hero;

	
	private int positionHeroX;
	private int positionHeroY;
	
	public int getPositionHeroX() {
		return positionHeroX;
	}

	public void setPositionHeroX(int positionHeroX) {
		this.positionHeroX = positionHeroX;
	}

	public int getPositionHeroY() {
		return positionHeroY;
	}

	public void setPositionHeroY(int positionHeroY) {
		this.positionHeroY = positionHeroY;
	}

	public int getHeight(){
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public char[][] tabmap2d = new char[this.getHeight()][this.getWidth()];

	/** The message. */
	private String message;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
		this.hero = new Hero();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Hero getHero(){
		return this.hero;
	}

	public void getMapInChar() {

	}

	public String getMessage() {
		return this.message;

	}


	public void putInTabmap(int i, int j, char car) {
		this.tabmap2d[i][j] = car;
	}

	public void doTheThing() {
		String[] tabmap = this.message.split("\n") ;
		for(int i =0; i<tabmap.length; i++)
		{
			for (int j =0; j<tabmap[i].length();j++)
			{
				switch (tabmap[i].charAt(j)) {
					case'O':
						this.putInTabmap(i,j,'O');
						break;
					case'R':
						this.putInTabmap(i,j,'R');
						break;
					case'S':
						this.putInTabmap(i,j,'S');
						break;
					case'T':
						this.putInTabmap(i,j,'T');
						break;
					case'Q':
						this.putInTabmap(i,j,'Q');
						break;
					case'P':
						this.putInTabmap(i,j,'P');
						break;
					case'N':
						this.putInTabmap(i,j,'N');
						break;
					case'M':
						this.putInTabmap(i,j,'M');
						break;
					case'L':
						this.putInTabmap(i,j,'L');
						break;
					case'K':
						this.putInTabmap(i,j,'K');
						break;
					case'J':
						this.putInTabmap(i,j,'J');
						break;
					case'I':
						this.putInTabmap(i,j,'I');
						break;
					case'U':
						this.putInTabmap(i,j,'U');
						break;
					case'V':
						this.putInTabmap(i,j,'V');
						break;
					case'X':
						this.putInTabmap(i,j,'X');
						break;
					case'Y':
						this.putInTabmap(i,j,'Y');
						break;
					case'Z':
						this.putInTabmap(i,j,'Z');
						break;
					case'A':
						this.putInTabmap(i,j,'A');
						setPositionHeroX(j);
						setPositionHeroY(i);
						break;
				}
			}
		}
		
	}
	public char[][] getTabmap2d() {
		return this.tabmap2d;
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

	public void moveG(int x ,int y) {
		if(isMovePossible(positionHeroX+x, positionHeroY+y))
		{

			tabmap2d[positionHeroY+y][positionHeroX+x]='A';
			tabmap2d[positionHeroY][positionHeroX]='O';
			setPositionHeroX(positionHeroX+x);
			setPositionHeroY(positionHeroY+y);

		}


		else {}
	}
	
	public boolean isMovePossible(int x,  int y)
	{
		if(tabmap2d[y][x] == 'O')
			return true;
		
		else 
			return false;
	}
	
}
