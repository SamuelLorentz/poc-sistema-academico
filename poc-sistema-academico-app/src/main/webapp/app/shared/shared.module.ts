import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { PocsistemaacademicoSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [PocsistemaacademicoSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [PocsistemaacademicoSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PocsistemaacademicoSharedModule {
  static forRoot() {
    return {
      ngModule: PocsistemaacademicoSharedModule
    };
  }
}
