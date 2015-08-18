public class Pet {
  private String mName; //name of pet
  private Float mFoodLevel;
  private Float mSleepLevel;
  private Float mActivityLevel;
  private Float mHappinessLevel;

  private String mHappinessDead = "I was ignored and I died."
  private String mHappinessLow = "I am very unhappy.";
  private String mHappinessModerate = "I could be happier.";
  private String mHappinessGood = "I am happy."

  public Pet (String name) {
      mName = name;
      mFoodLevel = 100;
      mSleepLevel = 100;
      mActivityLevel = 100;
      mHappinessLevel;//Ideal level = 300
    }

    public String getPet() {
      return mName;
    }
    public String getFoodLevel(){
      return mFoodLevel;
    }
    public String getSleepLevel(){
      return mSleepLevel;
    }
    public String getActivityLevel(){
      return mActivityLevel;
    }
    public String getHappinessLevel(){
      return mHappinessLevel;
    }

    public Integer HappinessLevel(){
      mFoodLevel + mSleepLevel + mActivityLevel;
    }

    public void feed(Float foodTime) {
      mFoodLevel += foodTime;
    }

    public void rest(Float sleepyTime) {
      mSleepLevel += sleepyTime;
    }

    public void play(Float playTime) {
      mActivityLevel += playTime);
    }

    public String happinessLevel(){
        if (mHappinessLevel == 0) {
          return mHappinessDead;
        }
        else if (0 < mHappinessLevel < 50) {
          return mHappinessLow;
        }
        else if (50 =< mHappinessLevel < 100) {
          return mHappinessModerate;
        }
        else {
          return mHappinessGood;
        }
      }
    }
