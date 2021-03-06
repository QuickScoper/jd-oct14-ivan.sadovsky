package day5.magazine.Service;

import java.util.Date;

import day5.magazine.Guitar.AcousticGuitar;
import day5.magazine.Guitar.BassGuitar;
import day5.magazine.Guitar.ElectricGuitar;
import day5.magazine.Guitar.FreatboardMaterial;
import day5.magazine.Guitar.Guitar;
import day5.magazine.Guitar.GuitarBrand;
import day5.magazine.Guitar.GuitarType;
import day5.magazine.Purchase.Purchase;

public class Store {

	private Guitar guitar[][][] = new Guitar[3][5][];
	private Purchase purchase[] = new Purchase[100];

	public Store() {
		fillStore();
	}

	private void fillStore() {

		ElectricGuitar g = new ElectricGuitar();
		addGuitarToStore(g);

		ElectricGuitar g1 = new ElectricGuitar("Machogony", "Seymor Duncan",
				"Seymor Duncan", true, GuitarBrand.ESP, "Black", "JP123",
				FreatboardMaterial.MACHOGONY, false, 7, 22, "Japan", 65000);
		addGuitarToStore(g1);

		ElectricGuitar g2 = new ElectricGuitar("Machogony", "Seymor Duncan",
				"EMG", false, GuitarBrand.FENDER, "Blue", "PO443",
				FreatboardMaterial.MACHOGONY, false, 7, 22, "Japan", 70000);
		addGuitarToStore(g2);

		BassGuitar g3 = new BassGuitar();
		addGuitarToStore(g3);

		BassGuitar g4 = new BassGuitar("Machogony", "EMG", "EMG", false,
				GuitarBrand.GIBSON, "White", "TE321",
				FreatboardMaterial.MACHOGONY, false, 4, 24, "Japan", 55000);
		addGuitarToStore(g4);

		AcousticGuitar g5 = new AcousticGuitar();
		addGuitarToStore(g5);

		AcousticGuitar g6 = new AcousticGuitar(GuitarBrand.GIBSON, "red",
				"RHD12", FreatboardMaterial.MAPLE, true, 6, 19, "Japan", 40000,
				true);
		addGuitarToStore(g6);

		AcousticGuitar g7 = new AcousticGuitar(GuitarBrand.JACKSON, "blue",
				"PR981", FreatboardMaterial.MACHOGONY, false, 12, 24, "USA",
				80000, true);
		addGuitarToStore(g7);

		ElectricGuitar g8 = new ElectricGuitar();
		addGuitarToStore(g8);

		ElectricGuitar g9 = new ElectricGuitar();
		addGuitarToStore(g9);

	}

	public void addGuitarToStore(Guitar g) {

		int k = 0;
		if (g instanceof AcousticGuitar) {
			k = 0;
			AcousticGuitar.increaseCountAcousticGuitar();
		}

		if (g instanceof ElectricGuitar && !(g instanceof BassGuitar)) {
			k = 1;
			ElectricGuitar.increaseCountElecticGuitar();
		}

		if (g instanceof BassGuitar) {
			k = 2;
			BassGuitar.increaseCountBassGuitar();
		}

		if (guitar[k] == null) {
			guitar[k] = new Guitar[5][];
		}

		if (guitar[k][g.getGuitarBrand().ordinal()] == null) {
			guitar[k][g.getGuitarBrand().ordinal()] = new Guitar[100];
		}

		int i = g.getGuitarBrand().ordinal();
		int j = getNumberOfGuitars(guitar[k][i]);

		guitar[k][i][j] = g;

	}

	public void printStore() {

		for (Guitar[][] guitarType : guitar) {
			if (guitarType != null) {
				for (Guitar[] guitarBrand : guitarType) {
					if (guitarBrand != null) {
						for (Guitar guitarTemp : guitarBrand) {
							if (guitarTemp != null) {
								if (guitarTemp instanceof ElectricGuitar
										&& !(guitarTemp instanceof BassGuitar)) {
									ElectricGuitar valueTemp = (ElectricGuitar) guitarTemp;
									System.out.println("Electric Guitar - "
											+ valueTemp.getGuitarBrand() + " "
											+ valueTemp.getColor() + " "
											+ valueTemp.getModel() + " "
											+ valueTemp.getFreatboardMaterial()
											+ " "
											+ valueTemp.isFreatboardGlued()
											+ " "
											+ valueTemp.getNumberOfStrings()
											+ " "
											+ valueTemp.getNumberOfFrets()
											+ " " + valueTemp.getManufacturer()
											+ " " + valueTemp.getPrice() + " "
											+ valueTemp.getBodyMaterial() + " "
											+ valueTemp.getNeckName() + " "
											+ valueTemp.getBridgeName() + " "
											+ valueTemp.isFloydRose());
								}

								if (guitarTemp instanceof BassGuitar) {
									BassGuitar valueTemp = (BassGuitar) guitarTemp;
									System.out.println("Bass Guitar - "
											+ valueTemp.getGuitarBrand() + " "
											+ valueTemp.getColor() + " "
											+ valueTemp.getModel() + " "
											+ valueTemp.getFreatboardMaterial()
											+ " "
											+ valueTemp.isFreatboardGlued()
											+ " "
											+ valueTemp.getNumberOfStrings()
											+ " "
											+ valueTemp.getNumberOfFrets()
											+ " " + valueTemp.getManufacturer()
											+ " " + valueTemp.getPrice() + " "
											+ valueTemp.getBodyMaterial() + " "
											+ valueTemp.getNeckName() + " "
											+ valueTemp.getBridgeName() + " "
											+ valueTemp.isFloydRose());
								}
								if (guitarTemp instanceof AcousticGuitar) {
									AcousticGuitar valueTemp = (AcousticGuitar) guitarTemp;
									System.out.println("Acoustic Guitar - "
											+ valueTemp.getGuitarBrand() + " "
											+ valueTemp.getColor() + " "
											+ valueTemp.getModel() + " "
											+ valueTemp.getFreatboardMaterial()
											+ " "
											+ valueTemp.isFreatboardGlued()
											+ " "
											+ valueTemp.getNumberOfStrings()
											+ " "
											+ valueTemp.getNumberOfFrets()
											+ " " + valueTemp.getManufacturer()
											+ " " + valueTemp.getPrice() + " "
											+ valueTemp.isStringsIsNylon());

								}
							}
						}
					}
				}
			}

		}
		System.out
				.println("_____________________________________________________________________________________________________________");

	}

	public void printPrices() {

		for (Guitar[][] guitarType : guitar) {
			if (guitarType != null) {
				for (Guitar[] guitarBrand : guitarType) {
					if (guitarBrand != null) {
						for (Guitar guitarTemp : guitarBrand) {
							if (guitarTemp != null) {
								System.out.println(guitarTemp
										.getClass()
										.getName()
										.substring(
												guitarTemp.getClass().getName()
														.lastIndexOf(".") + 1)
										+ " "
										+ guitarTemp.getGuitarBrand()
										+ " "
										+ guitarTemp.getColor()
										+ " "
										+ guitarTemp.getModel()
										+ " "
										+ guitarTemp.getPrice());

							}
						}
					}
				}
			}

		}

		System.out
				.println("________________________________________________________");

	}

	public void printNumberOfGuitarType() {

		System.out.println("We have " + AcousticGuitar.getCountAcousticGuitar()
				+ " acoustic guitars in the stock");
		System.out.println("We have " + ElectricGuitar.getCountElecticGuitar()
				+ " electric guitars in the stock");
		System.out.println("We have " + BassGuitar.getCountBassGuitar()
				+ " bass guitars in the stock");
		System.out
				.println("________________________________________________________");
	}

	public void printGuitarType(GuitarType guitarType) {
		
			for (int i = 0; i < guitar[guitarType.ordinal()].length; i++) {
				if (guitar[guitarType.ordinal()][i] != null) {
					for (int j = 0; j < guitar[guitarType.ordinal()][i].length; j++) {
						if (guitar[guitarType.ordinal()][i][j] != null) {
							System.out
									.println(guitar[guitarType.ordinal()][i][j]
											.getClass().getName()
											+ " "
											+ guitar[guitarType.ordinal()][i][j]
													.getGuitarBrand()
											+ " "
											+ guitar[guitarType.ordinal()][i][j]
													.getColor()
											+ " "
											+ guitar[guitarType.ordinal()][i][j]
													.getModel()
											+ " "
											+ guitar[guitarType.ordinal()][i][j]
													.getPrice());

						}
					}
				}
			}

		
		System.out
				.println("________________________________________________________");

	}

	public static int getNumberOfGuitars(Guitar[] guitar) {

		int i = 0;

		if (guitar != null) {
			while (guitar[i] != null) {
				i++;
			}
		}

		return i;

	}

	public Guitar[][][] getGuitar() {
		return guitar;
	}

	public int getGuitarIndexByModel(int k, int i, String model) {

		int index = -1;
		model = model.toUpperCase();		

		for (int j = 0; j < getNumberOfGuitars(guitar[k][i]); j++) {
			if (guitar[k][i][j].getModel().toUpperCase().equals(model)) {
				index = j;				
			}
		}

		return index;
	}

	public int getGuitarNumberByModel(int k, int i, String model) {

		int kol = 0;
		model = model.toUpperCase();

		for (int j = 0; j < getNumberOfGuitars(guitar[k][i]); j++) {
			if (guitar[k][i][j].getModel().toUpperCase().equals(model)) {
				kol++;
			}
		}

		return kol;
	}

	public Purchase[] getPurchase() {
		return purchase;
	}

	public void printPurchases() {

		int sum = 0;
		int number = 0;

		for (Purchase value : purchase) {
			if (value != null) {
				number++;
				sum += (value.getNumber() * value.getGuitar().getPrice());
				System.out.println("Purchase " + number + " "
						+ value.getCustomer().getName() + " "
						+ value.getGuitar().getGuitarBrand() + " "
						+ value.getGuitar().getModel() + " "
						+ value.getNumber() + " "
						+ (value.getNumber() * value.getGuitar().getPrice())
						+ " " + value.getDate());
			}

		}

		if (number != 0) {
			System.out
					.println("__________________________________________________");
			System.out.println("All " + number
					+ " purchases                            " + sum);
		} else
			System.out.println("At this time there is no purchases!");

	}

	public void printPurchasesByDate(Date date) {

		int sum = 0;
		int number = 0;

		for (Purchase value : purchase) {
			if (value != null && value.getDate().getDate() == date.getDate()) {
				number++;
				sum += (value.getNumber() * value.getGuitar().getPrice());
				System.out.println("Purchase " + number + " "
						+ value.getCustomer().getName() + " "
						+ value.getGuitar().getGuitarBrand() + " "
						+ value.getGuitar().getModel() + " "
						+ value.getNumber() + " "
						+ (value.getNumber() * value.getGuitar().getPrice())
						+ " " + value.getDate());
			}

		}

		if (number != 0) {
			System.out
					.println("__________________________________________________");
			System.out.println("All " + number
					+ " purchases                            " + sum);
		}

		else
			System.out.println("There is no purchases at this date!");

	}

	public void printNumberOfPurchasesByWeek() {

		Date now = new Date();
		int[] numberOfPurchaseByWeek = new int[7];

		for (Purchase value : purchase) {
			if (value != null) {

				for (int i = 0; i < numberOfPurchaseByWeek.length; i++) {
					if (value.getDate().getDate() == now.getDate()
							- (numberOfPurchaseByWeek.length - 1) + i) {
						numberOfPurchaseByWeek[i]++;
					}
				}

			}

		}

		for (int i = 0; i < numberOfPurchaseByWeek.length; i++) {

			if (i == numberOfPurchaseByWeek.length - 1) {
				System.out.println(numberOfPurchaseByWeek[i]
						+ " purchases were made today");
			} else if (i == numberOfPurchaseByWeek.length - 2) {
				System.out.println(numberOfPurchaseByWeek[i]
						+ " purchases were made yesterday");
			} else
				System.out
						.println(numberOfPurchaseByWeek[i]
								+ " purchases were made "
								+ (numberOfPurchaseByWeek.length - i - 1)
								+ " days ago");

		}

		System.out
				.println("__________________________________________________");

	}

}