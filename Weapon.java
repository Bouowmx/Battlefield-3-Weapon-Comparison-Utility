import static java.lang.Math.ceil;

public final class Weapon {
	public String NAME;
	public double MAX_DAMAGE, MIN_DAMAGE, DAMAGE_DO_START, DAMAGE_DO_END, RATE_OF_FIRE, MUZZLE_VELOCITY, SUPPRESSION, RECOIL_UP, RECOIL_LEFT, RECOIL_RIGHT, FIRST_SHOT_MULTIPLIER, RECOIL_DECREASE, ADS_STATIONARY_STANDING_SPREAD, ADS_STATIONARY_CROUCHING_SPREAD, ADS_STATIONARY_PRONE_SPREAD, ADS_MOVING_STANDING_SPREAD, ADS_MOVING_CROUCHING_SPREAD, ADS_MOVING_PRONE_SPREAD, HIP_STATIONARY_STANDING_SPREAD, HIP_STATIONARY_CROUCHING_SPREAD, HIP_STATIONARY_PRONE_SPREAD, HIP_MOVING_STANDING_SPREAD, HIP_MOVING_CROUCHING_SPREAD, HIP_MOVING_PRONE_SPREAD, SPREAD_INCREASE, SPREAD_DECREASE;
	public boolean SNIPER;
	public double[] BIPOD, FLASH_SUPPRESSOR, FOREGRIP, HEAVY_BARREL, SUPPRESSOR;
	public double LASER_SIGHT, LASER_SIGHT_PRIMARY;
	
	public Weapon(String name, double max_damage, double min_damage, double damage_do_start, double damage_do_end, double rate_of_fire, double muzzle_velocity, double suppression, double recoil_up, double recoil_left, double recoil_right, double first_shot_multiplier, double recoil_decrease, double ads_stationary_standing_spread, double ads_stationary_crouching_spread, double ads_stationary_prone_spread, double ads_moving_standing_spread, double ads_moving_crouching_spread, double ads_moving_prone_spread, double hip_stationary_standing_spread, double hip_stationary_crouching_spread, double hip_stationary_prone_spread, double hip_moving_standing_spread, double hip_moving_crouching_spread, double hip_moving_prone_spread, double spread_increase, double spread_decrease, boolean sniper, double[] bipod, double[] flash_suppressor, double[] foregrip, double[] heavy_barrel, double laser_sight, double laser_sight_primary, double[] suppressor) {
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
		BIPOD = bipod; 
		FLASH_SUPPRESSOR = flash_suppressor; 
		FOREGRIP = foregrip; 
		HEAVY_BARREL = heavy_barrel; 
		LASER_SIGHT = laser_sight; 
		LASER_SIGHT_PRIMARY = laser_sight_primary; 
		SUPPRESSOR = suppressor;
	}
	public Weapon(Weapon weapon) {
		NAME = weapon.NAME;
		MAX_DAMAGE = weapon.MAX_DAMAGE;
		MIN_DAMAGE = weapon.MIN_DAMAGE;
		DAMAGE_DO_START = weapon.DAMAGE_DO_START;
		DAMAGE_DO_END = weapon.DAMAGE_DO_END;
		RATE_OF_FIRE = weapon.RATE_OF_FIRE;
		MUZZLE_VELOCITY = weapon.MUZZLE_VELOCITY;
		SUPPRESSION = weapon.SUPPRESSION;
		RECOIL_UP = weapon.RECOIL_UP;
		RECOIL_LEFT = weapon.RECOIL_LEFT;
		RECOIL_RIGHT = weapon.RECOIL_RIGHT;
		FIRST_SHOT_MULTIPLIER = weapon.FIRST_SHOT_MULTIPLIER;
		RECOIL_DECREASE = weapon.RECOIL_DECREASE;
		ADS_STATIONARY_STANDING_SPREAD = weapon.ADS_STATIONARY_STANDING_SPREAD;
		ADS_STATIONARY_CROUCHING_SPREAD = weapon.ADS_STATIONARY_CROUCHING_SPREAD;
		ADS_STATIONARY_PRONE_SPREAD = weapon.ADS_STATIONARY_PRONE_SPREAD;
		ADS_MOVING_STANDING_SPREAD = weapon.ADS_MOVING_STANDING_SPREAD;
		ADS_MOVING_CROUCHING_SPREAD = weapon.ADS_MOVING_CROUCHING_SPREAD;
		ADS_MOVING_PRONE_SPREAD = weapon.ADS_MOVING_PRONE_SPREAD;
		HIP_STATIONARY_STANDING_SPREAD = weapon.HIP_STATIONARY_STANDING_SPREAD;
		HIP_STATIONARY_CROUCHING_SPREAD = weapon.HIP_STATIONARY_CROUCHING_SPREAD;
		HIP_STATIONARY_PRONE_SPREAD = weapon.HIP_STATIONARY_PRONE_SPREAD;
		HIP_MOVING_STANDING_SPREAD = weapon.HIP_MOVING_STANDING_SPREAD;
		HIP_MOVING_CROUCHING_SPREAD = weapon.HIP_MOVING_CROUCHING_SPREAD;
		HIP_MOVING_PRONE_SPREAD = weapon.HIP_MOVING_PRONE_SPREAD;
		SPREAD_INCREASE = weapon.SPREAD_INCREASE;
		SPREAD_DECREASE = weapon.SPREAD_DECREASE;
		SNIPER = weapon.SNIPER;
		BIPOD = weapon.BIPOD; 
		FLASH_SUPPRESSOR = weapon.FLASH_SUPPRESSOR; 
		FOREGRIP = weapon.FOREGRIP; 
		HEAVY_BARREL = weapon.HEAVY_BARREL; 
		LASER_SIGHT = weapon.LASER_SIGHT; 
		LASER_SIGHT_PRIMARY = weapon.LASER_SIGHT_PRIMARY; 
		SUPPRESSOR = weapon.SUPPRESSOR;
	}
	public Weapon(Weapon weapon, String attachment) {
		this(weapon);
		attach(attachment);
	}
	public Weapon(Weapon weapon, String primaryAttachment, String secondaryAttachment) {
		this(weapon);
		attach(primaryAttachment, secondaryAttachment);
	}
	public void attach(String attachment) {
		if (attachment.equals("Bipod") && (BIPOD != null)) {
			RECOIL_UP *= BIPOD[0];
			RECOIL_LEFT *= BIPOD[1];
			RECOIL_RIGHT *= BIPOD[1];
			ADS_STATIONARY_STANDING_SPREAD *= BIPOD[2];
			ADS_STATIONARY_CROUCHING_SPREAD *= BIPOD[2];
			ADS_STATIONARY_PRONE_SPREAD *= BIPOD[2];
			ADS_MOVING_STANDING_SPREAD *= BIPOD[2];
			ADS_MOVING_CROUCHING_SPREAD *= BIPOD[2];
			ADS_MOVING_PRONE_SPREAD *= BIPOD[2];
			HIP_STATIONARY_STANDING_SPREAD *= BIPOD[3];
			HIP_STATIONARY_CROUCHING_SPREAD *= BIPOD[3];
			HIP_STATIONARY_PRONE_SPREAD *= BIPOD[3];
			HIP_MOVING_STANDING_SPREAD *= BIPOD[3];
			HIP_MOVING_CROUCHING_SPREAD *= BIPOD[3];
			HIP_MOVING_PRONE_SPREAD *= BIPOD[3];
		}
		if (attachment.equals("Flash Suppressor") && (FLASH_SUPPRESSOR != null)) {
			RECOIL_UP *= FLASH_SUPPRESSOR[0];
			HIP_STATIONARY_STANDING_SPREAD *= FLASH_SUPPRESSOR[1];
			HIP_STATIONARY_CROUCHING_SPREAD *= FLASH_SUPPRESSOR[1];
			HIP_STATIONARY_PRONE_SPREAD *= FLASH_SUPPRESSOR[1];
			HIP_MOVING_STANDING_SPREAD *= FLASH_SUPPRESSOR[1];
			HIP_MOVING_CROUCHING_SPREAD *= FLASH_SUPPRESSOR[1];
			HIP_MOVING_PRONE_SPREAD *= FLASH_SUPPRESSOR[1];
		}
		if (attachment.equals("Foregrip") && (FOREGRIP != null)) {
			RECOIL_UP *= FOREGRIP[0];
			RECOIL_LEFT *= FOREGRIP[1];
			RECOIL_RIGHT *= FOREGRIP[1];
			ADS_STATIONARY_STANDING_SPREAD *= FOREGRIP[2];
			ADS_STATIONARY_CROUCHING_SPREAD *= FOREGRIP[2];
			ADS_STATIONARY_PRONE_SPREAD *= FOREGRIP[2];
			ADS_MOVING_STANDING_SPREAD *= FOREGRIP[2];
			ADS_MOVING_CROUCHING_SPREAD *= FOREGRIP[2];
			ADS_MOVING_PRONE_SPREAD *= FOREGRIP[2];
		}
		if (attachment.equals("Heavy Barrel") && (HEAVY_BARREL != null)) {
			if (HEAVY_BARREL[0] != -1) {DAMAGE_DO_END = HEAVY_BARREL[0];}
			if (HEAVY_BARREL[1] != -1) {MUZZLE_VELOCITY = HEAVY_BARREL[1];}
			RECOIL_UP *= HEAVY_BARREL[2];
			ADS_STATIONARY_STANDING_SPREAD *= HEAVY_BARREL[3];
			ADS_STATIONARY_CROUCHING_SPREAD *= HEAVY_BARREL[3];
			ADS_STATIONARY_PRONE_SPREAD *= HEAVY_BARREL[3];
			ADS_MOVING_STANDING_SPREAD *= HEAVY_BARREL[3];
			ADS_MOVING_CROUCHING_SPREAD *= HEAVY_BARREL[3];
			ADS_MOVING_PRONE_SPREAD *= HEAVY_BARREL[3];
			HIP_STATIONARY_STANDING_SPREAD *= HEAVY_BARREL[4];
			HIP_STATIONARY_CROUCHING_SPREAD *= HEAVY_BARREL[4];
			HIP_STATIONARY_PRONE_SPREAD *= HEAVY_BARREL[4];
			HIP_MOVING_STANDING_SPREAD *= HEAVY_BARREL[4];
			HIP_MOVING_CROUCHING_SPREAD *= HEAVY_BARREL[4];
			HIP_MOVING_PRONE_SPREAD *= HEAVY_BARREL[4];
		}
		if (attachment.equals("Laser Sight") && (LASER_SIGHT != -1)) {
			HIP_STATIONARY_STANDING_SPREAD *= LASER_SIGHT;
			HIP_STATIONARY_CROUCHING_SPREAD *= LASER_SIGHT;
			HIP_STATIONARY_PRONE_SPREAD *= LASER_SIGHT;
			HIP_MOVING_STANDING_SPREAD *= LASER_SIGHT;
			HIP_MOVING_CROUCHING_SPREAD *= LASER_SIGHT;
			HIP_MOVING_PRONE_SPREAD *= LASER_SIGHT;
		}
		if (attachment.equals("Laser Sight (Primary)") && (LASER_SIGHT_PRIMARY != -1)) {
			HIP_STATIONARY_STANDING_SPREAD *= LASER_SIGHT_PRIMARY;
			HIP_STATIONARY_CROUCHING_SPREAD *= LASER_SIGHT_PRIMARY;
			HIP_STATIONARY_PRONE_SPREAD *= LASER_SIGHT_PRIMARY;
			HIP_MOVING_STANDING_SPREAD *= LASER_SIGHT_PRIMARY;
			HIP_MOVING_CROUCHING_SPREAD *= LASER_SIGHT_PRIMARY;
			HIP_MOVING_PRONE_SPREAD *= LASER_SIGHT_PRIMARY;
		}
		if (attachment.equals("Suppressor") && (SUPPRESSOR != null)) {
			if (SUPPRESSOR[0] != -1) {DAMAGE_DO_START = SUPPRESSOR[0];}
			if (SUPPRESSOR[1] != -1) {DAMAGE_DO_END = SUPPRESSOR[1];}
			if (SUPPRESSOR[2] != -1) {MUZZLE_VELOCITY = SUPPRESSOR[2];}
			RECOIL_UP *= SUPPRESSOR[3];
			ADS_STATIONARY_STANDING_SPREAD *= SUPPRESSOR[4];
			ADS_STATIONARY_CROUCHING_SPREAD *= SUPPRESSOR[4];
			ADS_STATIONARY_PRONE_SPREAD *= SUPPRESSOR[4];
			ADS_MOVING_STANDING_SPREAD *= SUPPRESSOR[4];
			ADS_MOVING_CROUCHING_SPREAD *= SUPPRESSOR[4];
			ADS_MOVING_PRONE_SPREAD *= SUPPRESSOR[4];
			HIP_STATIONARY_STANDING_SPREAD *= SUPPRESSOR[5];
			HIP_STATIONARY_CROUCHING_SPREAD *= SUPPRESSOR[5];
			HIP_STATIONARY_PRONE_SPREAD *= SUPPRESSOR[5];
			HIP_MOVING_STANDING_SPREAD *= SUPPRESSOR[5];
			HIP_MOVING_CROUCHING_SPREAD *= SUPPRESSOR[5];
			HIP_MOVING_PRONE_SPREAD *= SUPPRESSOR[5];
		}
	}
	public void attach(String primaryAttachment, String secondaryAttachment) {
		attach(primaryAttachment);
		attach(secondaryAttachment);
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
