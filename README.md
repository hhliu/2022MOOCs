## 2022.05.02
### **設置監聽器的三種方法**  
#### 方法一：使用android:onClick屬性
---
Note:  
Android Studio: Bumblebee 2021.1.1 patch3, targetSDK: 31
新版本Android Studio預設的Theme改為Theme.MaterialComponents，舊版本為Theme.AppCompt，這樣改動讓很多視圖元件的顯示和屬性設定變得不同，讓初學者在觀看舊專案的影片然後進行新專案的開發時產生一些困擾，尤其是本專案的minSDK設定為19的緣故，部分Material Design Component無法正常地被顯示。  
修改方式為將minSDK設定為24或更高，想要挑戰自己的同學再維持minSDK為19