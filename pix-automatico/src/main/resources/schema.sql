-- Sequence for usuarios
CREATE SEQUENCE usuario_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- Tabela de Usuários
CREATE TABLE usuarios (
    usuario_id NUMBER PRIMARY KEY,
    nome VARCHAR2(100) NOT NULL,
    cpf VARCHAR2(11) NOT NULL UNIQUE,
    email VARCHAR2(100) NOT NULL UNIQUE,
    telefone VARCHAR2(15),
    senha_hash VARCHAR2(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autenticacao_2f NUMBER(1) DEFAULT 0 CHECK (autenticacao_2f IN (0, 1))
);

CREATE OR REPLACE TRIGGER usuario_bir
BEFORE INSERT ON usuarios
FOR EACH ROW
BEGIN
    :new.usuario_id := usuario_seq.NEXTVAL;
END;
/

-- Sequence for contas
CREATE SEQUENCE conta_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- Tabela de Contas
CREATE TABLE contas (
    conta_id NUMBER PRIMARY KEY,
    usuario_id NUMBER,
    banco VARCHAR2(50) NOT NULL,
    numero_conta VARCHAR2(20) NOT NULL,
    agencia VARCHAR2(10) NOT NULL,
    tipo_conta VARCHAR2(10) NOT NULL CHECK (tipo_conta IN ('corrente', 'poupanca')),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

CREATE OR REPLACE TRIGGER conta_bir
BEFORE INSERT ON contas
FOR EACH ROW
BEGIN
    :new.conta_id := conta_seq.NEXTVAL;
END;
/

-- Sequence for pagamentos_recorrentes
CREATE SEQUENCE pagamento_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- Tabela de Pagamentos Recorrentes
CREATE TABLE pagamentos_recorrentes (
    pagamento_id NUMBER PRIMARY KEY,
    usuario_id NUMBER,
    valor DECIMAL(10, 2) NOT NULL,
    data_vencimento DATE NOT NULL,
    frequencia VARCHAR2(10) NOT NULL CHECK (frequencia IN ('diaria', 'semanal', 'mensal')),
    descricao VARCHAR2(255),
    status VARCHAR2(10) NOT NULL CHECK (status IN ('ativo', 'cancelado')),
    autorizacao_previa NUMBER(1) DEFAULT 0 CHECK (autorizacao_previa IN (0, 1)),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

CREATE OR REPLACE TRIGGER pagamento_bir
BEFORE INSERT ON pagamentos_recorrentes
FOR EACH ROW
BEGIN
    :new.pagamento_id := pagamento_seq.NEXTVAL;
END;
/

-- Sequence for transacoes
CREATE SEQUENCE transacao_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- Tabela de Transações
CREATE TABLE transacoes (
    transacao_id NUMBER PRIMARY KEY,
    pagamento_id NUMBER,
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_transacao DECIMAL(10, 2) NOT NULL,
    status_transacao VARCHAR2(10) NOT NULL CHECK (status_transacao IN ('sucesso', 'falha')),
    FOREIGN KEY (pagamento_id) REFERENCES pagamentos_recorrentes(pagamento_id)
);

CREATE OR REPLACE TRIGGER transacao_bir
BEFORE INSERT ON transacoes
FOR EACH ROW
BEGIN
    :new.transacao_id := transacao_seq.NEXTVAL;
END;
/

-- Sequence for notificacoes
CREATE SEQUENCE notificacao_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- Tabela de Notificações
CREATE TABLE notificacoes (
    notificacao_id NUMBER PRIMARY KEY,
    usuario_id NUMBER,
    mensagem VARCHAR2(255) NOT NULL,
    data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR2(10) NOT NULL CHECK (status IN ('lida', 'nao_lida')),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

CREATE OR REPLACE TRIGGER notificacao_bir
BEFORE INSERT ON notificacoes
FOR EACH ROW
BEGIN
    :new.notificacao_id := notificacao_seq.NEXTVAL;
END;
/

-- Sequence for logs_atividade
CREATE SEQUENCE log_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- Tabela de Logs de Atividade
CREATE TABLE logs_atividade (
    log_id NUMBER PRIMARY KEY,
    usuario_id NUMBER,
    acao VARCHAR2(20) NOT NULL CHECK (acao IN ('criacao', 'atualizacao', 'cancelamento')),
    data_acao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

CREATE OR REPLACE TRIGGER log_bir
BEFORE INSERT ON logs_atividade
FOR EACH ROW
BEGIN
    :new.log_id := log_seq.NEXTVAL;
END;
/