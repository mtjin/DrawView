# DrawView
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![](https://jitpack.io/v/mtjin/DrawView.svg)](https://jitpack.io/#mtjin/DrawView)
<br>
Library that draw on View and have some useful functions
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

There is also sample code in this repository.

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

Download File to gallery and get the Uri, it needs WRITE_EXTERNAL_STORAGE permission (drawVie file)
```kotlin
 drawView.saveFileDrawViewGetUri()
```

Download File to gallery and get the Uri, it needs WRITE_EXTERNAL_STORAGE permission (draw line file , background : whitecolor)
```kotlin
 drawView.saveFileDrawLineGetUri()
```

It can also set by xml
```xml
<com.mtjin.library.DrawView
       android:layout_width="wrap_content"
       app:pen_color="#4455B7"
       app:pen_stroke="#9D3434"
       android:layout_height="wrap_content"/>
```

## Images
<img src="https://user-images.githubusercontent.com/37071007/78999801-56c7f300-7b86-11ea-99e6-1a361edd2290.png" align="left" height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999818-61828800-7b86-11ea-8884-e91584522f35.png" align="left" height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999833-66473c00-7b86-11ea-843f-16b2ee59d063.png" align="left" height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999839-6a735980-7b86-11ea-9563-835ace663d6e.png" align="left" height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999843-6cd5b380-7b86-11ea-9848-13482607d284.png" align="left" height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999850-6fd0a400-7b86-11ea-95c8-8f7c8bd842df.png" align="left" height="400" width="200" >

