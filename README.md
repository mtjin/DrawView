# DrawView
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![](https://jitpack.io/v/mtjin/DrawView.svg)](https://jitpack.io/#mtjin/DrawView)
<br>
draw on View and have some useful functions
It is useful for drawing and signature

## Prerequisites
Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.mtjin:DrawView:v1.0'
}
```

## Usage

To change pen color
```kotlin
drawView.setPenColor(Color.parseColor("#D81B60"))
```

To change pen stroke width
```kotlin
drawView.setStrokeWidth(20f)
```

To undo draw 
```kotlin
drawView.undo()
```

To redo draw 
```kotlin
drawView.redo()
```

To clear all draw
```kotlin
drawView.clear()
```

To get Bitmap from only draw line of DrawView
```kotlin
val bitmap = drawView.getBitmapDrawLine()
imageView.setImageBitmap(bitmap)
```

To get Bitmap from DrawView
```kotlin
val bitmap = drawView.getBitmap()
imageView.setImageBitmap(bitmap)
```

Save File and get the Uri, it needs WRITE_EXTERNAL_STORAGE permission (drawVie file)
```kotlin
 drawView.saveFileDrawViewGetUri()
```

Save File and get the Uri, it needs WRITE_EXTERNAL_STORAGE permission (draw line file , background : whitecolor)
```kotlin
 drawView.saveFileDrawLineGetUri()
```
