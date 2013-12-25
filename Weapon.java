package Battlefield3WeaponComparison;

import static java.lang.Math.ceil;

final class Weapon {
	public String NAME;
	public double MAX_DAMAGE, MIN_DAMAGE, DAMAGE_DO_START, DAMAGE_DO_END, RATE_OF_FIRE, MUZZLE_VELOCITY, SUPPRESSION, RECOIL_UP, RECOIL_LEFT, RECOIL_RIGHT, FIRST_SHOT_MULTIPLIER, RECOIL_DECREASE, ADS_STATIONARY_STANDING_SPREAD, ADS_STATIONARY_CROUCHING_SPREAD, ADS_STATIONARY_PRONE_SPREAD, ADS_MOVING_STANDING_SPREAD, ADS_MOVING_CROUCHING_SPREAD, ADS_MOVING_PRONE_SPREAD, HIP_STATIONARY_STANDING_SPREAD, HIP_STATIONARY_CROUCHING_SPREAD, HIP_STATIONARY_PRONE_SPREAD, HIP_MOVING_STANDING_SPREAD, HIP_MOVING_CROUCHING_SPREAD, HIP_MOVING_PRONE_SPREAD, SPREAD_INCREASE, SPREAD_DECREASE;
	public boolean SNIPER;
	
	public Weapon(String name, double max_damage, double min_damage, double damage_do_start, double damage_do_end, double rate_of_fire, double muzzle_velocity, double suppression, double recoil_up, double recoil_left, double recoil_right, double first_shot_multiplier, double recoil_decrease, double ads_stationary_standing_spread, double ads_stationary_crouching_spread, double ads_stationary_prone_spread, double ads_moving_standing_spread, double ads_moving_crouching_spread, double ads_moving_prone_spread, double hip_stationary_standing_spread, double hip_stationary_crouching_spread, double hip_stationary_prone_spread, double hip_moving_standing_spread, double hip_moving_crouching_spread, double hip_moving_prone_spread, double spread_increase, double spread_decrease, boolean sniper) {
		NAME = name;
		MAX_DAMAGE = max_damage;
		MIN_DAMAGE = min_damage;
		DAMAGE_DO_START = damage_do_start;
		DAMAGE_DO_END = damage_do_end;
		RATE_OF_FIRE = rate_of_fire;
		MUZZLE_VELOCITY = muzzle_velocity;
		SUPPRESSION = suppression;
		RECOIL_UP = recoil_up;
		RECOIL_LEFT = recoil_left;
		RECOIL_RIGHT = recoil_right;
		FIRST_SHOT_MULTIPLIER = first_shot_multiplier;
		RECOIL_DECREASE = recoil_decrease;
		ADS_STATIONARY_STANDING_SPREAD = ads_stationary_standing_spread;
		ADS_STATIONARY_CROUCHING_SPREAD = ads_stationary_crouching_spread;
		ADS_STATIONARY_PRONE_SPREAD = ads_stationary_prone_spread;
		ADS_MOVING_STANDING_SPREAD = ads_moving_standing_spread;
		ADS_MOVING_CROUCHING_SPREAD = ads_moving_crouching_spread;
		ADS_MOVING_PRONE_SPREAD = ads_moving_prone_spread;
		HIP_STATIONARY_STANDING_SPREAD = hip_stationary_standing_spread;
		HIP_STATIONARY_CROUCHING_SPREAD = hip_stationary_crouching_spread;
		HIP_STATIONARY_PRONE_SPREAD = hip_stationary_prone_spread;
		HIP_MOVING_STANDING_SPREAD = hip_moving_standing_spread;
		HIP_MOVING_CROUCHING_SPREAD = hip_moving_crouching_spread;
		HIP_MOVING_PRONE_SPREAD = hip_moving_prone_spread;
		SPREAD_INCREASE = spread_increase;
		SPREAD_DECREASE = spread_decrease;
		SNIPER = sniper;
	}
	
	public void attach(String attachment, double... modifiers) { //An array can be passed for varargs
		if (attachment.equals("Bipod")) {
			RECOIL_UP *= modifiers[0];
			RECOIL_LEFT *= modifiers[1];
			RECOIL_RIGHT *= modifiers[1];
			ADS_STATIONARY_STANDING_SPREAD = modifiers[2];
			ADS_STATIONARY_CROUCHING_SPREAD = modifiers[2];
			ADS_STATIONARY_PRONE_SPREAD = modifiers[2];
			ADS_MOVING_STANDING_SPREAD = modifiers[2];
			ADS_MOVING_CROUCHING_SPREAD = modifiers[2];
			ADS_MOVING_PRONE_SPREAD = modifiers[2];
			HIP_STATIONARY_STANDING_SPREAD = modifiers[3];
			HIP_STATIONARY_CROUCHING_SPREAD = modifiers[3];
			HIP_STATIONARY_PRONE_SPREAD = modifiers[3];
			HIP_MOVING_STANDING_SPREAD = modifiers[3];
			HIP_MOVING_CROUCHING_SPREAD = modifiers[3];
			HIP_MOVING_PRONE_SPREAD = modifiers[3];
		}
		if (attachment.equals("Flash Suppressor")) {
			RECOIL_UP *= modifiers[0];
			HIP_STATIONARY_STANDING_SPREAD = modifiers[1];
			HIP_STATIONARY_CROUCHING_SPREAD = modifiers[1];
			HIP_STATIONARY_PRONE_SPREAD = modifiers[1];
			HIP_MOVING_STANDING_SPREAD = modifiers[1];
			HIP_MOVING_CROUCHING_SPREAD = modifiers[1];
			HIP_MOVING_PRONE_SPREAD = modifiers[1];
		}
		if (attachment.equals("Foregrip")) {
			RECOIL_UP *= modifiers[0];
			RECOIL_LEFT *= modifiers[1];
			RECOIL_RIGHT *= modifiers[1];
			ADS_STATIONARY_STANDING_SPREAD = modifiers[2];
			ADS_STATIONARY_CROUCHING_SPREAD = modifiers[2];
			ADS_STATIONARY_PRONE_SPREAD = modifiers[2];
			ADS_MOVING_STANDING_SPREAD = modifiers[2];
			ADS_MOVING_CROUCHING_SPREAD = modifiers[2];
			ADS_MOVING_PRONE_SPREAD = modifiers[2];
		}
		if (attachment.equals("Heavy Barrel")) {
			if (modifiers[0] != 0) {DAMAGE_DO_END = modifiers[0];}
			if (modifiers[1] != 0) {MUZZLE_VELOCITY = modifiers[1];}
			RECOIL_UP *= modifiers[2];
			ADS_STATIONARY_STANDING_SPREAD = modifiers[3];
			ADS_STATIONARY_CROUCHING_SPREAD = modifiers[3];
			ADS_STATIONARY_PRONE_SPREAD = modifiers[3];
			ADS_MOVING_STANDING_SPREAD = modifiers[3];
			ADS_MOVING_CROUCHING_SPREAD = modifiers[3];
			ADS_MOVING_PRONE_SPREAD = modifiers[3];
			HIP_STATIONARY_STANDING_SPREAD = modifiers[4];
			HIP_STATIONARY_CROUCHING_SPREAD = modifiers[4];
			HIP_STATIONARY_PRONE_SPREAD = modifiers[4];
			HIP_MOVING_STANDING_SPREAD = modifiers[4];
			HIP_MOVING_CROUCHING_SPREAD = modifiers[4];
			HIP_MOVING_PRONE_SPREAD = modifiers[4];
		}
		if (attachment.equals("Laser Sight") || attachment.equals("Laser Sight (Primary)")) {
			HIP_STATIONARY_STANDING_SPREAD = modifiers[0];
			HIP_STATIONARY_CROUCHING_SPREAD = modifiers[0];
			HIP_STATIONARY_PRONE_SPREAD = modifiers[0];
			HIP_MOVING_STANDING_SPREAD = modifiers[0];
			HIP_MOVING_CROUCHING_SPREAD = modifiers[0];
			HIP_MOVING_PRONE_SPREAD = modifiers[0];
		}
		if (attachment.equals("Suppressor")) {
			DAMAGE_DO_START = modifiers[0];
			DAMAGE_DO_END = modifiers[1];
			if (modifiers[2] != 0) {MUZZLE_VELOCITY = modifiers[2];}
			RECOIL_UP *= modifiers[3];
			ADS_STATIONARY_STANDING_SPREAD = modifiers[4];
			ADS_STATIONARY_CROUCHING_SPREAD = modifiers[4];
			ADS_STATIONARY_PRONE_SPREAD = modifiers[4];
			ADS_MOVING_STANDING_SPREAD = modifiers[4];
			ADS_MOVING_CROUCHING_SPREAD = modifiers[4];
			ADS_MOVING_PRONE_SPREAD = modifiers[4];
			HIP_STATIONARY_STANDING_SPREAD = modifiers[5];
			HIP_STATIONARY_CROUCHING_SPREAD = modifiers[5];
			HIP_STATIONARY_PRONE_SPREAD = modifiers[5];
			HIP_MOVING_STANDING_SPREAD = modifiers[5];
			HIP_MOVING_CROUCHING_SPREAD = modifiers[5];
			HIP_MOVING_PRONE_SPREAD = modifiers[5];
		}
	}
	public void attach(String primaryAttachment, double[] primaryAttachmentModifiers, String secondaryAttachment, double[] secondaryAttachmentModifiers) {
		attach(primaryAttachment, primaryAttachmentModifiers);
		attach(secondaryAttachment, secondaryAttachmentModifiers);
	}
	
	public double damage(double distance) {
		if (distance <= DAMAGE_DO_START) {return MAX_DAMAGE;}
		if (distance >= DAMAGE_DO_END) {return MIN_DAMAGE;}
		return MAX_DAMAGE + (((MIN_DAMAGE - MAX_DAMAGE) / (DAMAGE_DO_END - DAMAGE_DO_START)) * (distance - DAMAGE_DO_START));
	}
	
	public double hitKillDistance(double health, int hits) {
		if ((hits < ceil(100 / MAX_DAMAGE)) || (hits > ceil(100 / MIN_DAMAGE))) {return 0.0;}
		if (hits == ceil(100 / MAX_DAMAGE)) {return DAMAGE_DO_START;}
		if (hits == ceil(100 / MIN_DAMAGE)) {
			if (SNIPER) {return 5 * MUZZLE_VELOCITY;}
			else {return 1.5 * MUZZLE_VELOCITY;}
		}
		return ((100 / hits) - MAX_DAMAGE) / ((MIN_DAMAGE - MAX_DAMAGE) / (DAMAGE_DO_END - DAMAGE_DO_START)) + DAMAGE_DO_START;
	}
		
	public double timeToKill(double health, double distance) {return 1000 * (((60 / RATE_OF_FIRE) * ((ceil(health / damage(distance))) - 1)) + (distance / MUZZLE_VELOCITY));}
	
	@Override
	public String toString() {return NAME + ", " + MAX_DAMAGE + ", " + MIN_DAMAGE + ", " + DAMAGE_DO_START + ", " + DAMAGE_DO_END + ", " + RATE_OF_FIRE + ", " + MUZZLE_VELOCITY + ", " + SUPPRESSION + ", " + RECOIL_UP + ", " + RECOIL_LEFT + ", " + RECOIL_RIGHT + ", " + FIRST_SHOT_MULTIPLIER + ", " + RECOIL_DECREASE + ", " + ADS_STATIONARY_STANDING_SPREAD + ", " + ADS_STATIONARY_CROUCHING_SPREAD + ", " + ADS_STATIONARY_PRONE_SPREAD + ", " + ADS_MOVING_STANDING_SPREAD + ", " + ADS_MOVING_CROUCHING_SPREAD + ", " + ADS_MOVING_PRONE_SPREAD + ", " + HIP_STATIONARY_STANDING_SPREAD + ", " + HIP_STATIONARY_CROUCHING_SPREAD + ", " + HIP_STATIONARY_PRONE_SPREAD + ", " + HIP_MOVING_STANDING_SPREAD + ", " + HIP_MOVING_CROUCHING_SPREAD + ", " + HIP_MOVING_PRONE_SPREAD + ", " + SPREAD_INCREASE + ", " + SPREAD_DECREASE + ", " + SNIPER;}
}
