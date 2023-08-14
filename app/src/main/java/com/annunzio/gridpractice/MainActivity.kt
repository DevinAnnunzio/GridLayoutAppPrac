package com.annunzio.gridpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.annunzio.gridpractice.data.DataSource
import com.annunzio.gridpractice.model.Course
import com.annunzio.gridpractice.ui.theme.GridPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridApp(){
    CourseGridLayout(coursesList = DataSource.DataSource.courses)
}

@Composable
fun CourseGridItem(course: Course, modifier: Modifier = Modifier){
    Card(modifier = modifier) {

        Row() {
            Image(painter = painterResource(course.courseImageResourceId),
                contentDescription = stringResource(course.courseTitleResourceId),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),)
            Column {
                Text(text = LocalContext.current.getString(course.courseTitleResourceId), modifier = modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp))
                Row {
                    Image(painter = painterResource(id = R.drawable.ic_grain), contentDescription = "Grain image", modifier = modifier.padding(start = 16.dp, end = 8.dp))
                    Text(text = course.associatedCourses.toString())
                }
            }
        }
    }
}

@Composable
fun CourseGridLayout(coursesList : List<Course>, modifier: Modifier = Modifier){
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 150.dp), modifier = modifier){
        items(coursesList.size){course ->
            CourseGridItem(coursesList[course])
        }

    }

}


@Composable
@Preview
private fun CardPreview(){
    GridApp()
}