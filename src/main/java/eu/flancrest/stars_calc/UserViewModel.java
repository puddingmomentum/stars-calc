package eu.flancrest.stars_calc;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UserViewModel {

	private static final Logger logger = LogManager.getLogger(UserViewModel.class);

	private int getMiningRate() {
		String sMiningRate = iMiningRate.getValue();
		int MiningRate = 0;

		if (sMiningRate.isBlank()) {
			return 0;
		}

		String sanitized = sMiningRate.replaceAll("[^0-9]", "");
		MiningRate = Integer.parseInt(sanitized);
		logger.info("MiningRate: {}", MiningRate);

		return MiningRate;
	}

	private int getResource() {
		String sResources = numResources.getValue();
		int iResources = 0;

		if (sResources.isBlank()) {
			return 0;
		}

		String sanitized = sResources.replaceAll("[^0-9]", "");
		iResources = Integer.parseInt(sanitized);

		logger.info("iResources: {}", iResources);

		return iResources;
	}

	private int getAutoMines() {
		String sAutoMines = numAutoBuildMines.getValue();
		int iAutoMines = 0;

		if (sAutoMines.isBlank()) {
			return 0;
		}

		String sanitized = sAutoMines.replaceAll("[^0-9]", "");
		iAutoMines = Integer.parseInt(sanitized);

		logger.info("AutoMines: {}", iAutoMines);

		return iAutoMines;
	}

	private int getAutoFactories() {
		String sAutoFactories = numAutoBuildFactories.getValue();
		int iAutoFactories = 0;

		if (sAutoFactories.isBlank()) {
			return 0;
		}

		String sanitized = sAutoFactories.replaceAll("[^0-9]", "");
		iAutoFactories = Integer.parseInt(sanitized);

		logger.info("AutoMines: {}", iAutoFactories);

		return iAutoFactories;
	}

	public void calc() {
		int result = calcFactories();
		StringBuilder sb = new StringBuilder();
		sb.append(result);
		numPossExtraFactories.setValue(sb.toString());

		sb.setLength(0);
		result = calcMines();
		sb.append(result);
		numPossExtraMines.setValue(sb.toString());
	}

	public void clear() {
		numResources.setValue("");
		numAutoBuildFactories.setValue("");
		numAutoBuildMines.setValue("");
		iMiningRate.setValue("");
		numPossExtraMines.setValue("");
		numPossExtraFactories.setValue("");
		numDesiredFactories.setValue("");
		numPossMines.setValue("");
		numDesiredMines.setValue("");
		numPossFactories.setValue("");
	}

	private int calcFactories() {
		int iResources = getResource();
		int iGermaniumMiningRate = getMiningRate();
		int iAutoMines = getAutoMines();
		int iAutoFactories = getAutoFactories();
		int iAutoMineralsUsed = 0, iAutoResourcesUsed = 0;
		int iResourcesRemaining = 0, iMineralsRemaining = 0;

		float fResources = 0, fGermanium = 0;

		iAutoMineralsUsed = iAutoFactories * 4;
		iAutoResourcesUsed = (iAutoFactories * 10) + (iAutoMines * 5);

		iResourcesRemaining = iResources - iAutoResourcesUsed;
		iMineralsRemaining = iGermaniumMiningRate - iAutoMineralsUsed;

		logger.info("Resources Remaining: {}, Minerals Remaining {}", iResourcesRemaining, iMineralsRemaining);

		if (iResources > 0) {
			fResources = iResourcesRemaining / 10;
		}

		if (iGermaniumMiningRate > 0) {
			fGermanium = iMineralsRemaining / 4;
		}

		return fResources < fGermanium ? (int) fResources : (int) fGermanium;
	}

	private int calcMines() {
		int iResources = getResource();
		int iAutoMines = getAutoMines();
		int iAutoFactories = getAutoFactories();
		int iAutoResourcesUsed = 0, iMines = 0;

		float fResources = 0;

		iAutoResourcesUsed = (iAutoFactories * 10) + (iAutoMines * 5);

		iResources = iResources - iAutoResourcesUsed;

		if (iResources > 0) {
			fResources = iResources / 5;
		}

		logger.info("Mines: {} ", fResources);

		iMines = (int) fResources;

		return iMines;
	}

	private final StringProperty numResources = new SimpleStringProperty("");

	public StringProperty numResources() {
		return numResources;
	}

	private final StringProperty numAutoBuildFactories = new SimpleStringProperty("");

	public StringProperty numAutoBuildFactories() {
		return numAutoBuildFactories;
	}

	private final StringProperty numAutoBuildMines = new SimpleStringProperty("");

	public StringProperty numAutoBuildMines() {
		return numAutoBuildMines;
	}

	private final StringProperty iMiningRate = new SimpleStringProperty("");

	public StringProperty iMiningRate() {
		return iMiningRate;
	}

	private final StringProperty numPossExtraMines = new SimpleStringProperty("");

	public StringProperty numPossExtraMines() {
		return numPossExtraMines;
	}

	private final StringProperty numPossExtraFactories = new SimpleStringProperty("");

	public StringProperty numPossExtraFactories() {
		return numPossExtraFactories;
	}

	private final StringProperty numDesiredFactories = new SimpleStringProperty("");

	public StringProperty numDesiredFactories() {
		return numDesiredFactories;
	}

	private final StringProperty numPossMines = new SimpleStringProperty("");

	public StringProperty numPossMines() {
		return numPossMines;
	}

	private final StringProperty numDesiredMines = new SimpleStringProperty("");

	public StringProperty numDesiredMines() {
		return numDesiredMines;
	}

	private final StringProperty numPossFactories = new SimpleStringProperty("");

	public StringProperty numPossFactories() {
		return numPossFactories;
	}
}
