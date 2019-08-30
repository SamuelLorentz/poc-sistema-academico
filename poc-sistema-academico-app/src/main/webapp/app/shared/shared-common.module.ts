import { NgModule } from '@angular/core';

import { PocsistemaacademicoSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [PocsistemaacademicoSharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [PocsistemaacademicoSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class PocsistemaacademicoSharedCommonModule {}
