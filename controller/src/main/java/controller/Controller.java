package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage(" " + " ");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */

	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case m1:
				this.model.loadMessage("m1");
				break;
			case m2:
				this.model.loadMessage("m2");
				break;
			case m3:
				this.model.loadMessage("m3");
				break;
			case m4:
				this.model.loadMessage("m4");
				break;
			case m5:
				this.model.loadMessage("m5");
				break;

			default:
				break;
		}
	}



	/**public class Maps{

			ArrayList<String> lignes = new ArrayList<String>();
			String fichier ="aaaaaaaaaaaaaaaaaaaaaaaaaaa";
			BufferedReader br = null;

			try{
				br = new BufferedReader(new FileReader(fichier));
				String ligne="";
				while((ligne = br.readLine()) != null){
					lignes.add(ligne);

				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
			if (br != null)
				try {
					br.close();
				}catch (IOException ioe){
					ioe.printStackTrace();
				}

				}
		}**/


}
