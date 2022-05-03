## 2022.05.03
### **ConstraintLayout**  
---
Note:  
在使用Button的時候，發現他的背景顏色無法被更改，這是由於新版本Android Studio預設使用了Theme.MaterialComponent所帶來的限制。詳細的說明需要去參考https://material.io/components/buttons的內容。一般處理的方式有三種，可任選一種使用：

1. 在xml裡面，將Button元件改成使用androidx.appcompat.widget.AppCompatButton
2. 在xml裡面，將app:backgroundTint屬性改成”@null”。(i.e., app:backgroundTint=”@null”)
3. 將預設Theme改成使用parent="Theme.MaterialComponents.DayNight.NoActionBar.Bridge"