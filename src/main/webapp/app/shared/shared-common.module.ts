import { NgModule } from '@angular/core';

import { BooksWithJhipsterSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [BooksWithJhipsterSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [BooksWithJhipsterSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class BooksWithJhipsterSharedCommonModule {}
