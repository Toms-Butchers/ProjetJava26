package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * The Class ViewPanel.
 *
  */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {

		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override


	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		this.viewFrame.getModel().tabmap();
		char [][] mapmap = this.viewFrame.getModel().getMap2D();

			for(int i=0; i<mapmap.length; i++)
			{
				for(int j=0; j<mapmap[i].length; j++)
				{
					switch (mapmap[i][j]){
						case 'R':try {
							Image img = ImageIO.read(new File("sprite/bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'S':try {
							Image img = ImageIO.read(new File("sprite/horizontal_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'T':try {
							Image img = ImageIO.read(new File("sprite/vertical_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'Q':try {
							Image img = ImageIO.read(new File("sprite/gate_closed.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'P':try {
							Image img = ImageIO.read(new File("sprite/gate.open.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'N':try {
							Image img = ImageIO.read(new File("sprite/crystal_ball.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'M':try {
							Image img = ImageIO.read(new File("sprite/fireball_5.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'L':try {
							Image img = ImageIO.read(new File("sprite/fireball_4.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'K':try {
							Image img = ImageIO.read(new File("sprite/fireball_3.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'J':try {
							Image img = ImageIO.read(new File("sprite/fireball_2.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'I':try {
							Image img = ImageIO.read(new File("sprite/fireball_1.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'U':try {
							Image img = ImageIO.read(new File("sprite/monster_1.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'V':try {
							Image img = ImageIO.read(new File("sprite/monster_2.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'X':try {
							Image img = ImageIO.read(new File("sprite/monster_3.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'Y':try {
							Image img = ImageIO.read(new File("sprite/monster_4.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;

						case 'O':try {
							Image img = ImageIO.read(new File("  "));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;
						case 'Z':try {
							Image img = ImageIO.read(new File("sprite/purse.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch(IOException e) {
							e.printStackTrace();
						}
							break;


					}
				}
				//graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
			}


		//graphics.drawString(this.getViewFrame().getModel().getMessage(), 10, 20);
	}
}
