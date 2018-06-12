ALTER TABLE public.material
ADD CONSTRAINT fk_tipo
FOREIGN KEY (fk_tipo) REFERENCES public.tipomaterial (id);

ALTER TABLE public.material
ADD CONSTRAINT fk_status_material
FOREIGN KEY (fk_status_material) REFERENCES public.status_material (id);

ALTER TABLE public.material
ADD CONSTRAINT fk_categoria
FOREIGN KEY (fk_categoria) REFERENCES public.categoria (id);

ALTER TABLE public.funcionario
ADD CONSTRAINT fk_setor
FOREIGN KEY (fk_setor) REFERENCES public.setor (id);

ALTER TABLE public.funcionario
ADD CONSTRAINT fk_tipo_funcionario
FOREIGN KEY (fk_tipofuncionario) REFERENCES public.tipofuncionario (id);

ALTER TABLE public.historico
ADD CONSTRAINT fk_status_solicitacoes
FOREIGN KEY (fk_status_solicitacao) REFERENCES public.status_solicitacoes (id);

ALTER TABLE public.solicitacoes
ADD CONSTRAINT fk_material
FOREIGN KEY (fk_material) REFERENCES public.material (id);

ALTER TABLE public.solicitacoes
ADD CONSTRAINT fk_tipo_material
FOREIGN KEY (fk_tipo_material) REFERENCES public.tipomaterial (id);

ALTER TABLE public.solicitacoes
ADD CONSTRAINT fk_categoria
FOREIGN KEY (fk_categoria) REFERENCES public.categoria (id);

ALTER TABLE public.solicitacoes
ADD CONSTRAINT fk_material_status
FOREIGN KEY (fk_status_material) REFERENCES public.status_material (id);

ALTER TABLE public.solicitacoes
ADD CONSTRAINT fk_solicitacoes_status
FOREIGN KEY (fk_status_solicitacoes) REFERENCES public.status_solicitacoes (id);

ALTER TABLE public.solicitacoes
ADD CONSTRAINT fk_historico
FOREIGN KEY (fk_historico) REFERENCES public.historico (id);

ALTER TABLE public.solicitacoes
ADD CONSTRAINT fk_setor
FOREIGN KEY (fk_setor) REFERENCES public.setor (id);

ALTER TABLE public.solicitacoes
ADD CONSTRAINT fk_funcionario
FOREIGN KEY (fk_funcionario) REFERENCES public.funcionario (id);

ALTER TABLE public.solicitacoes
ADD CONSTRAINT fk_tipo_funcionario
FOREIGN KEY (fk_tipo_funcionario) REFERENCES public.tipofuncionario (id);

