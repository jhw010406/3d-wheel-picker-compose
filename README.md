# Introduce
Simple 3D Wheel Picker for Android Compose

# Preview
<div align=center><img src="https://github.com/user-attachments/assets/bc24a0e7-eb31-486a-8d05-821f198292de"></div>

# How to include
Just import WheelPickerView.kt to your project

# Usage
```kotlin
fun WheelPickerDialog(
    initIdx: Int = 0,
    suffix: String = "",
    onDismissRequest: () -> Unit,
    onConfirm: (Any) -> Unit,
    optionList: List<String>
)
```
<ul>
  <li>initIdx = set first element's index on the options list</li>
  <li>suffix = set element's suffix</li>
  <li>onDismissRequest = callback when dialog canceled</li>
  <li>onConfirm = callback when select any element on options list</li>
  <li>optionsList = the list what you want to show in dialog</li>
</ul>
