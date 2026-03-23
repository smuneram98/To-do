import { Routes } from '@angular/router';
import { NotasComponent } from './view/notas.component/notas.component/notas.component';

export const routes: Routes = [
    { path: '', redirectTo: 'notas', pathMatch: 'full' },
    { path: 'notas', component: NotasComponent }
];
