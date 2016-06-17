package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

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
		this.view.printMessage("YO :) ");
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
			case MoveLeft:
				this.model.moveG(-1, 0);
				break;
			case MoveRight:
				this.model.moveG(1 ,0);
				break;
			case MoveUp:
				this.model.moveG(0 , -1);
				break;
			case MoveDown:
				this.model.moveG(0 , 1);
				break;
			/*case DiaLeftUp:
				this.model.moveG();
				break;*/
			default:
				break;
		}
	}

}
