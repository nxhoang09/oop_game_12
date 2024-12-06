package utilz;

import main.Game;

public class Constants {

	public static final float GRAVITY = 0.04f * Game.SCALE;
	public static final int ANI_SPEED = 25;

	public static class Dialogue {
		public static final int QUESTION = 0;
		public static final int EXCLAMATION = 1;

		public static final int DIALOGUE_WIDTH = (int) (14 * Game.SCALE);
		public static final int DIALOGUE_HEIGHT = (int) (12 * Game.SCALE);

		public static int GetSpriteAmount(int type) {
			switch (type) {
			case QUESTION, EXCLAMATION:
				return 5;
			}

			return 0;
		}
	}

	public static class Projectiles {
		public static final int CANNON_BALL_DEFAULT_WIDTH = 15;
		public static final int CANNON_BALL_DEFAULT_HEIGHT = 15;

		public static final int CANNON_BALL_WIDTH = (int) (Game.SCALE * CANNON_BALL_DEFAULT_WIDTH);
		public static final int CANNON_BALL_HEIGHT = (int) (Game.SCALE * CANNON_BALL_DEFAULT_HEIGHT);
		public static final float SPEED = 0.75f * Game.SCALE;
	}

	public static class ObjectConstants {

		public static final int RED_POTION = 0;
		public static final int BLUE_POTION = 1;
		public static final int BARREL = 2;
		public static final int BOX = 3;
		public static final int SPIKE = 4;
		public static final int CANNON_LEFT = 5;
		public static final int CANNON_RIGHT = 6;
		public static final int DECOR_ONE = 7;
		public static final int DECOR_TWO = 8;
		public static final int DECOR_THREE = 9;

		public static final int RED_POTION_VALUE = 15;
		public static final int BLUE_POTION_VALUE = 10;

		public static final int CONTAINER_WIDTH_DEFAULT = 40;
		public static final int CONTAINER_HEIGHT_DEFAULT = 30;
		public static final int CONTAINER_WIDTH = (int) (Game.SCALE * CONTAINER_WIDTH_DEFAULT);
		public static final int CONTAINER_HEIGHT = (int) (Game.SCALE * CONTAINER_HEIGHT_DEFAULT);

		public static final int POTION_WIDTH_DEFAULT = 12;
		public static final int POTION_HEIGHT_DEFAULT = 16;
		public static final int POTION_WIDTH = (int) (Game.SCALE * POTION_WIDTH_DEFAULT);
		public static final int POTION_HEIGHT = (int) (Game.SCALE * POTION_HEIGHT_DEFAULT);

		public static final int SPIKE_WIDTH_DEFAULT = 32;
		public static final int SPIKE_HEIGHT_DEFAULT = 32;
		public static final int SPIKE_WIDTH = (int) (Game.SCALE * SPIKE_WIDTH_DEFAULT);
		public static final int SPIKE_HEIGHT = (int) (Game.SCALE * SPIKE_HEIGHT_DEFAULT);

		public static final int CANNON_WIDTH_DEFAULT = 40;
		public static final int CANNON_HEIGHT_DEFAULT = 26;
		public static final int CANNON_WIDTH = (int) (CANNON_WIDTH_DEFAULT * Game.SCALE);
		public static final int CANNON_HEIGHT = (int) (CANNON_HEIGHT_DEFAULT * Game.SCALE);

		public static int GetSpriteAmount(int object_type) {
			switch (object_type) {
			case RED_POTION, BLUE_POTION:
				return 7;
			case BARREL, BOX:
				return 8;
			case CANNON_LEFT, CANNON_RIGHT:
				return 7;
			}
			return 1;
		}

		public static int GetDecorOffsetX(int decorType) {
			switch (decorType) {
			case DECOR_ONE:
				return (Game.TILES_SIZE / 2) - (GetDecorWidth(decorType) / 2);

			case DECOR_TWO:
				//return (int) (Game.TILES_SIZE / 2.5f);
				return (Game.TILES_SIZE / 2) - (GetDecorWidth(decorType) / 2);
			case DECOR_THREE:
				return (int) (Game.TILES_SIZE / 1.65f);
			}

			return 0;
		}

		public static int GetDecorOffsetY(int decorType) {

			switch (decorType) {
			case DECOR_ONE:
				return -GetDecorHeight(decorType) + (int) (Game.TILES_SIZE * 1.4);
			case DECOR_TWO, DECOR_THREE:
				return -GetDecorHeight(decorType) + (int) (Game.TILES_SIZE * 1.1 );
			}
			return 0;

		}

		public static int GetDecorWidth(int decorType) {
			switch (decorType) {
			case DECOR_ONE:
				return (int) (64 * Game.SCALE);
			case DECOR_TWO:
				return (int) (32 * Game.SCALE);
			case DECOR_THREE:
				return -(int) (62 * Game.SCALE);

			}
			return 0;
		}

		public static int GetDecorHeight(int decorType) {
			switch (decorType) {
			case DECOR_ONE:
				return (int) (int) (64 * Game.SCALE);
			case DECOR_TWO, DECOR_THREE:
				return (int) (32 * Game.SCALE);

			}
			return 0;
		}
	}

	public static class EnemyConstants {
		public static final int SNAKE = 0;
//		public static final int CRABBY = 0;
		public static final int GORDON = 1;
		public static final int WOLF = 2;

		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int ATTACK = 2;
		public static final int HIT = 3;
		public static final int DEAD = 4;

		public static final int SNAKE_WIDTH_DEFAULT = 64;
		public static final int SNAKE_HEIGHT_DEFAULT = 63;
		public static final int SNAKE_WIDTH = (int) (SNAKE_WIDTH_DEFAULT * Game.SCALE);
		public static final int SNAKE_HEIGHT = (int) (SNAKE_HEIGHT_DEFAULT * Game.SCALE);
		public static final int SNAKE_DRAWOFFSET_X = (int) (8 * Game.SCALE);
		public static final int SNAKE_DRAWOFFSET_Y = (int) (18 * Game.SCALE);

		public static final int GORDON_WIDTH_DEFAULT = 96;
		public static final int GORDON_HEIGHT_DEFAULT = 96;
		public static final int GORDON_WIDTH = (int) (GORDON_WIDTH_DEFAULT * Game.SCALE);
		public static final int GORDON_HEIGHT = (int) (GORDON_HEIGHT_DEFAULT * Game.SCALE);
		public static final int GORDON_DRAWOFFSET_X = (int) (9 * Game.SCALE);
		public static final int GORDON_DRAWOFFSET_Y = (int) (70 * Game.SCALE);

		public static final int WOLF_WIDTH_DEFAULT = 64;
		public static final int WOLF_HEIGHT_DEFAULT = 64;
		public static final int WOLF_WIDTH = (int) (WOLF_WIDTH_DEFAULT * Game.SCALE);
		public static final int WOLF_HEIGHT = (int) (WOLF_HEIGHT_DEFAULT * Game.SCALE);
		public static final int WOLF_DRAWOFFSET_X = (int) (8 * Game.SCALE);
		public static final int WOLF_DRAWOFFSET_Y = (int) (40 * Game.SCALE);

		public static int GetSpriteAmount(int enemy_type, int enemy_state) {
			switch (enemy_state) {

			case IDLE: {
//				if (enemy_type == CRABBY)
//					return 9;
				if (enemy_type == GORDON)
					return 8;
				else if (enemy_type == SNAKE || enemy_type == WOLF)
					return 6;
			}
			case RUNNING:
				if(enemy_type == WOLF)
					return 5;
				return 6;
			case ATTACK:
				if (enemy_type == WOLF)
					return 5;
				else if(enemy_type == SNAKE)
					return 6;
				return 7;
			case HIT:
				if (enemy_type == SNAKE)
					return 6;
				return 4;
			case DEAD:
				// if (enemy_type == SNAKE)
				// 	return 6;
				 if(enemy_type == WOLF)
					return 7;
				return 5;
			}

			return 0;

		}

		public static int GetMaxHealth(int enemy_type) {
			switch (enemy_type) {
			case SNAKE:
				return 40;
			case WOLF:
				return 40;
            case GORDON:
                return 60;
			default:
				return 1;
			}
		}

		public static int GetEnemyDmg(int enemy_type) {
			switch (enemy_type) {
			case SNAKE:
				return 15;
			case GORDON:
				return 20;
			case WOLF:
				return 25;
			default:
				return 0;
			}
		}
	}

	public static class Environment {
		//public static final int LAYER_IMG_WIDTH_DEFAUT = 704 ;
		public static final int LAYER_IMG_HEIGHT_DEFAULT = 416;
		public static final int SMALL_CLOUD_WIDTH_DEFAULT = 74;
		public static final int SMALL_CLOUD_HEIGHT_DEFAULT = 24;
		public static final float LAYER_IMG_WIDTH_DEFAULT = 704;
		
		public static final int LAYER_IMG_WIDTH = (int) (LAYER_IMG_WIDTH_DEFAULT * Game.SCALE);
		public static final int LAYER_IMG_HEIGHT = (int) (LAYER_IMG_HEIGHT_DEFAULT * Game.SCALE);
		public static final int SMALL_CLOUD_WIDTH = (int) (SMALL_CLOUD_WIDTH_DEFAULT * Game.SCALE);
		public static final int SMALL_CLOUD_HEIGHT = (int) (SMALL_CLOUD_HEIGHT_DEFAULT * Game.SCALE);
	}

	public static class UI {
		public static class Buttons {
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}
		public static class QSButton {
			public static final int QS_WIDTH_DEFAULT = 54;
			public static final int QS_HEIGHT_DEFAULT = 55;
			public static final int QS_WIDTH = (int) (QS_WIDTH_DEFAULT * Game.SCALE);
			public static final int QS_HEIGHT = (int) (QS_HEIGHT_DEFAULT * Game.SCALE);
		}

		public static class PauseButtons {
			public static final int SOUND_SIZE_DEFAULT = 42;
			public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);
		}

		public static class URMButtons {
			public static final int URM_DEFAULT_SIZE = 56;
			public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);

		}

		public static class VolumeButtons {
			public static final int VOLUME_DEFAULT_WIDTH = 28;
			public static final int VOLUME_DEFAULT_HEIGHT = 44;
			public static final int SLIDER_DEFAULT_WIDTH = 215;

			public static final int VOLUME_WIDTH = (int) (VOLUME_DEFAULT_WIDTH * Game.SCALE);
			public static final int VOLUME_HEIGHT = (int) (VOLUME_DEFAULT_HEIGHT * Game.SCALE);
			public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * Game.SCALE);
		}
	}

	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class PlayerConstants {
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int ATTACK = 4;
		public static final int HIT = 5;
		public static final int DEAD = 6;

//		public static int GetSpriteAmount(int player_action) {
//			switch (player_action) {
//			case DEAD:
//				return 8;
//			case RUNNING:
//				return 6;
//			case IDLE:
//				return 5;
//			case HIT:
//				return 4;
//			case JUMP:
//			case ATTACK:
//				return 3;
//			case FALLING:
//			default:
//				return 1;
//			}
//		}
	}

}